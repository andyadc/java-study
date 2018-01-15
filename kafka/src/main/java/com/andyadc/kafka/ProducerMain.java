package com.andyadc.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.andyadc.kafka.Const.BROKER_SERVER;

/**
 * @author andaicheng
 * @since 2018/1/14
 */
public class ProducerMain {

    private static final Logger LOG = LoggerFactory.getLogger(ProducerMain.class);

    /**
     * 设置实例生产消息的总数
     */
    private static final int MSG_SIZE = 10;

    /**
     * 主题名称
     */
    private static final String TOPIC_STOCK = "test";

    private static final int THREAD_NUMS = 3;

    private static KafkaProducer<String, String> producer = null;

    static {
        // 1.构造用于实例化 KafkaProducer 的 Properties 信息
        Properties properties = initConfig();
        // 2.初始化一个 KafkaProducer (线程安全)
        producer = new KafkaProducer<>(properties);
    }

    public static void main(String[] args) {
        simpleSend();
//        sendCallback();
//        sendMultiThread();
    }

    private static void sendMultiThread() {
        ProducerRecord<String, String> record = null;
        StockQuotationInfo info = null;

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMS);
        long current = System.currentTimeMillis();

        try {
            for (int i = 0; i < MSG_SIZE; i++) {
                info = createQuotationInfo();
                record = new ProducerRecord<>(TOPIC_STOCK, null,
                        info.getTradeTime(),
                        info.getStockCode(),
                        info.toString());

                executor.submit(new KafkaProducerThread(producer, record));
            }

        } catch (Exception e) {
            LOG.error("Send message occurs exception", e);
        } finally {
            producer.close();
            executor.shutdown();
        }

        LOG.info("Send message elapsed {}ms", (System.currentTimeMillis() - current));
    }

    private static void sendCallback() {
        ProducerRecord<String, String> record = null;
        StockQuotationInfo info = null;
        try {
            int num = 0;
            for (int i = 0; i < MSG_SIZE; i++) {
                info = new StockQuotationInfo();
                record = new ProducerRecord<>(TOPIC_STOCK, null,
                        info.getTradeTime(),
                        info.getStockCode(),
                        info.toString());

                producer.send(record, (metadata, exception) -> {

                    if (null != exception) {
                        LOG.error("Send message occurs exception.", exception);
                    }
                    if (null != metadata) {
                        LOG.info(String.format("offset:%s, partition:%s", metadata.offset(), metadata.partition()));
                    }

                }); // 异步发送消息

                if (num++ % 10 == 0) {
                    TimeUnit.SECONDS.sleep(2);
                }
            }

            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }

    private static void simpleSend() {
        ProducerRecord<String, String> record = null;
        StockQuotationInfo info = null;
        try {
            int num = 0;
            for (int i = 0; i < MSG_SIZE; i++) {
                info = createQuotationInfo();
                record = new ProducerRecord<>(TOPIC_STOCK, null, info.getTradeTime(), info.getStockCode(), info.toString());
                producer.send(record); // 异步发送消息
                if (num++ % 10 == 0) {
                    TimeUnit.SECONDS.sleep(2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }

    /**
     * 初始化kafka配置
     */
    private static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_SERVER);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }

    /**
     * 生产股票行情信息
     */
    private static StockQuotationInfo createQuotationInfo() {
        StockQuotationInfo quotationInfo = new StockQuotationInfo();
        // 随机产生1到10之间的整数，然后与600100相加组成股票代码
        Random r = new Random();
        Integer stockCode = 600100 + r.nextInt(10);
        // 随机产生一个0到1之间的浮点数
        float random = (float) Math.random();
        // 设置涨跌规则
        if (random / 2 < 0.5) {
            random = -random;
        }
        DecimalFormat decimalFormat = new DecimalFormat(".00");// 设置保存两位有效数字
        quotationInfo.setCurrentPrice(Float.valueOf(decimalFormat.format(11 +
                random)));// 设置最新价在11元浮动
        quotationInfo.setPreClosePrice(11.80f);// 设置昨日收盘价为固定值
        quotationInfo.setOpenPrice(11.5f);// 设置开盘价
        quotationInfo.setLowPrice(10.5f);// 设置最低价，并不考虑10%限制，
        //以及当前价是否已是最低价
        quotationInfo.setHighPrice(12.5f);// 设置最高价，并不考虑10%限制，
        //以及当前价是否已是最高价
        quotationInfo.setStockCode(stockCode.toString());
        quotationInfo.setTradeTime(System.currentTimeMillis());
        quotationInfo.setStockName("股票-" + stockCode);
        return quotationInfo;
    }
}

class KafkaProducerThread implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerThread.class);

    private KafkaProducer<String, String> producer = null;
    private ProducerRecord<String, String> record = null;

    public KafkaProducerThread(KafkaProducer<String, String> producer, ProducerRecord<String, String> record) {
        this.producer = producer;
        this.record = record;
    }

    @Override
    public void run() {
        producer.send(record, (metadata, exception) -> {
            if (exception != null) {// 发送异常记录异常信息
                LOG.error("Send message occurs exception.", exception);
            }
            if (null != metadata) {
                LOG.info(String.format("offset:%s, partition:%s", metadata.offset(), metadata.partition()));
            }
        });
    }

}

class StockQuotationInfo implements Serializable {

    private static final long serialVersionUID = -7296097714335356388L;

    /**
     * 股票代码
     */
    private String stockCode;
    /**
     * 股票名称
     */
    private String stockName;
    /**
     * 交易时间
     */
    private long tradeTime;
    /**
     * 昨日收盘价
     */
    private float preClosePrice;
    /**
     * 开盘价
     */
    private float openPrice;
    /**
     * 当前价,收盘时即为当日收盘价
     */
    private float currentPrice;
    /**
     * 今日最高价
     */
    private float highPrice;
    /**
     * 今日最低价
     */
    private float lowPrice;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public long getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(long tradeTime) {
        this.tradeTime = tradeTime;
    }

    public float getPreClosePrice() {
        return preClosePrice;
    }

    public void setPreClosePrice(float preClosePrice) {
        this.preClosePrice = preClosePrice;
    }

    public float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public float getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(float highPrice) {
        this.highPrice = highPrice;
    }

    public float getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(float lowPrice) {
        this.lowPrice = lowPrice;
    }

    @Override
    public String toString() {
        return "StockQuotationInfo{" +
                "stockCode=" + stockCode +
                ", stockName=" + stockName +
                ", tradeTime=" + tradeTime +
                ", preClosePrice=" + preClosePrice +
                ", openPrice=" + openPrice +
                ", currentPrice=" + currentPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                "}";
    }
}