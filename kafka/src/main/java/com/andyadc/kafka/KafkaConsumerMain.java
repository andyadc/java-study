package com.andyadc.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndTimestamp;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.andyadc.kafka.Const.BROKER_SERVER;

/**
 * @author andy.an
 * @since 2018/1/15
 */
public class KafkaConsumerMain {

    public static void main(String[] args) {
//        consumeAutoCommit();
//        consumeHandCommit();
        consumeTimestamp();
    }

    /**
     * 以时间戳查询消息
     */
    private static void consumeTimestamp() {
        Properties props = basicConfig();
        props.put("enable.auto.commit", true);// 显示设置偏移量自动提交
        props.put("auto.commit.interval.ms", 1000);// 设置偏移量提交时间间隔

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        // 订阅主题
        consumer.assign(Arrays.asList(new TopicPartition("test", 0)));

        try {
            Map<TopicPartition, Long> timestampsToSearch = new HashMap<>();
            // 构造待查询的分区
            TopicPartition partition = new TopicPartition("test", 0);
            // 设置查询12小时之前消息的偏移量
            timestampsToSearch.put(partition, (System.currentTimeMillis() - 12 * 3600 * 1000));
            // 会返回时间大于等于查找时间的第一个偏移量
            Map<TopicPartition, OffsetAndTimestamp> offsetMap = consumer.offsetsForTimes(timestampsToSearch);

            OffsetAndTimestamp offsetAndTimestamp = null;
            // 这里依然用 for 轮询，当然由于本例是查询的一个分区，因此也可以用 if 处理
            for (Map.Entry<TopicPartition, OffsetAndTimestamp> entry : offsetMap.entrySet()) {
                // 若查询时间大于时间戳索引文件中最大记录索引时间，
                // 此时 value 为空,即待查询时间点之后没有新消息生成
                offsetAndTimestamp = entry.getValue();
                if (offsetAndTimestamp != null) {
                    // 重置消费起始偏移量
                    consumer.seek(partition, entry.getValue().offset());
                }
            }

            while (true) {
                // 等待拉取消息
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    // 简单打印出消息内容
                    System.out.printf("partition= %d, offset= %d,key= %s value= %s%n",
                            record.partition(), record.offset(), record.key(), record.value());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }

    }

    /**
     * 手动提交消费偏移量
     */
    private static void consumeHandCommit() {
        Properties props = basicConfig();
        props.put("enable.auto.commit", "false"); // 显示设置偏移量手动提交
        props.put("fetch.max.bytes", 1024);// 为了便于测试，这里设置一次 fetch 请求取得的数据最大值为1KB,默认是5MB

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test"));

        try {
            int minCommitSize = 10;// 最少处理10条消息后才进行提交
            int icount = 0;// 消息计算器

            while (true) {
                // 等待拉取消息
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    // 简单打印出消息内容,模拟业务处理
                    System.out.printf("partition= %d, offset= %d, key= %s value= %s%n",
                            record.partition(), record.offset(), record.key(), record.value());
                    icount++;
                }

                // 在业务逻辑处理成功后提交偏移量
                if (icount >= minCommitSize) {
                    consumer.commitAsync((offsets, exception) -> {
                        if (null == exception) {
                            System.out.println("提交成功");
                        } else {
                            System.out.println("发生了异常");
                        }
                    });

                    icount = 0; // 重置计数器
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    /**
     * 自动提交偏移量
     */
    private static void consumeAutoCommit() {
        Properties props = basicConfig();
        props.put("enable.auto.commit", "true"); // 显示设置偏移量自动提交
        props.put("auto.commit.interval.ms", 1000); // 设置偏移量提交时间间隔

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test"));// 订阅主题

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(10000);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("partition= %d, offset= %d,key= %s value= %s%n",
                            record.partition(),
                            record.offset(),
                            record.key(),
                            record.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    private static Properties basicConfig() {
        Properties props = new Properties();
        props.put("group.id", "test");
        props.put("client.id", "test");
        props.put("bootstrap.servers", BROKER_SERVER);
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        return props;
    }

}
