//package com.andyadc.kafka;
//
//import kafka.api.FetchRequestBuilder;
//import kafka.api.PartitionOffsetRequestInfo;
//import kafka.common.TopicAndPartition;
//import kafka.api.FetchRequest;
//import kafka.javaapi.FetchResponse;
//import kafka.api.OffsetRequest;
//import kafka.javaapi.OffsetResponse;
//import kafka.javaapi.PartitionMetadata;
//import kafka.javaapi.TopicMetadata;
//import kafka.javaapi.consumer.SimpleConsumer;
//import kafka.javaapi.TopicMetadataRequest;
//import kafka.javaapi.TopicMetadataResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author andy.an
// * @since 2018/1/15
// */
//public class SimpleConsumerMain {
//
//    private static final Logger LOG = LoggerFactory.getLogger(SimpleConsumerMain.class);
//
//    /**
//     * 指定 Kafka 集群代理列表,列表无需指定所有的代理地址,
//     * 只要保证能连上 Kafka 集群即可，一般建议多个节点时至少写两个节点的地址
//     */
//    private static final String BROKER_LIST = "172.117.12.61,172.117.12.62";
//    /**
//     * 连接超时时间设置为1分钟
//     */
//    private static final int TIME_OUT = 60 * 1000;
//    /**
//     * 设置读取消息缓冲区大小
//     */
//    private static final int BUFFER_SIZE = 1024 * 1024;
//    /**
//     * 设置每次获取消息的条数
//     */
//    private static final int FETCH_SIZE = 100000;
//    /**
//     * broker的端口
//     */
//    private static final int PORT = 9092;
//    /**
//     * 设置容忍发生错误时重试的最大次数
//     */
//    private static final int MAX_ERROR_NUM = 3;
//
//    public void consume(List<String> brokerList, int port, String topic, int partitionId) {
//        SimpleConsumer consumer = null;
//
//        try {
//            // 1.首先获取指定分区的元数据信息
//            PartitionMetadata metadata = fetchPartitionMetadata(brokerList, port, topic, partitionId);
//            if (metadata == null) {
//                LOG.error("Can't find metadata info");
//                return;
//            }
//            if (metadata.leader() == null) {
//                LOG.error("Can't find the partition: " + partitionId + "'s leader.");
//                return;
//            }
//            String leadBroker = metadata.leader().host();
//            String clientId = "client-" + topic + "-" + partitionId;
//
//            // 2.创建一个消息者作为消费消息的真正执行者
//            consumer = new SimpleConsumer(leadBroker, port, TIME_OUT, BUFFER_SIZE, clientId);
//
//            // 设置时间为 kafka.api.OffsetRequest.EarliestTime()从最新消息起始处开始
//            long lastOffset = getLastOffset(consumer, topic, partitionId, kafka.api.OffsetRequest.EarliestTime(), clientId);
//
//            int errorNum = 0;
//            FetchRequest fetchRequest = null;
//            FetchResponse fetchResponse = null;
//
//            while (lastOffset > -1) {
//                // 当在循环过程中出错时将起始实例化的 consumer 关闭并设置为 null
//                if (consumer == null) {
//                    consumer = new SimpleConsumer(leadBroker, port, TIME_OUT, BUFFER_SIZE, clientId);
//                }
//            }
//
//            // 3.构造获取消息的 request
//            fetchRequest = new FetchRequestBuilder().clientId(clientId).addFetch(topic, partitionId, lastOffset, FETCH_SIZE).build();
//
//            // 4.获取响应并处理
//            fetchResponse = consumer.fetch(fetchRequest);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (consumer != null) {
//                consumer.close();
//            }
//        }
//
//
//    }
//
//    /**
//     * 消息偏移量
//     *
//     * @param consumer
//     * @param topic
//     * @param partition
//     * @param beginTime
//     * @param clientName
//     * @return
//     */
//    private long getLastOffset(SimpleConsumer consumer, String topic, int partition, long
//            beginTime, String clientName) {
//
//        TopicAndPartition topicAndPartition = new TopicAndPartition(topic, partition);
//
//        Map<TopicAndPartition, PartitionOffsetRequestInfo> requestInfo = new HashMap<>();
//
//        // 设置获取消息起始 offset
//        requestInfo.put(topicAndPartition, new PartitionOffsetRequestInfo(beginTime, 1));
//        // 构造获取 offset 请求
//        OffsetRequest offsetReq = new OffsetRequest(requestInfo, kafka.api.OffsetRequest.CurrentVersion(), clientName);
//
//        OffsetResponse offsetResp = consumer.getOffsetsBefore(offsetReq);
//
//        if (offsetResp.hasError()) {
//            LOG.error("Fetch last offset occurs exception:" + offsetResp.errorCode(topic, partition));
//            return -1;
//        }
//
//        long[] offsets = offsetResp.offsets(topic, partition);
//        if (offsets == null || offsets.length == 0) {
//            LOG.error("Fetch last offset occurs error,offses is null.");
//            return -1;
//        }
//
//        return offsets[0];
//    }
//
//    /**
//     * 获取分区元数据
//     *
//     * @param brokerList
//     * @param port
//     * @param topic
//     * @param partitionId
//     * @return
//     */
//    private PartitionMetadata fetchPartitionMetadata(List<String> brokerList, int port, String topic, int partitionId) {
//        SimpleConsumer consumer = null;
//        TopicMetadataRequest metadataReq = null;
//        TopicMetadataResponse metadataResp = null;
//
//        List<TopicMetadata> topicMetadatas = null;
//
//        try {
//            for (String host : brokerList) {
//                // 1.构造一个消费者用于获取元数据信息的执行者
//                consumer = new SimpleConsumer(host, port, TIME_OUT, BUFFER_SIZE, "fetch-metadata");
//                // 2.构造请求主题的元数据的 request
//                metadataReq = new TopicMetadataRequest(Arrays.asList(topic));
//
//                try {
//                    metadataResp = consumer.send(metadataReq);
//                } catch (Exception e) {
//                    LOG.error("Send topicMetadataRequest occurs exception.", e);
//                    continue;
//                }
//
//                // 4.获取主题元数据列表
//                topicMetadatas = metadataResp.topicsMetadata();
//
//                // 5.主题元数据列表中提取指定分区的元数据信息
//                for (TopicMetadata metadata : topicMetadatas) {
//                    for (PartitionMetadata item : metadata.partitionsMetadata()) {
//                        if (item.partitionId() != partitionId) {
//                            continue;
//                        } else {
//                            return item;
//                        }
//                    }
//                }
//
//            }
//        } catch (Exception e) {
//            LOG.error("Fetch PartitionMetadata occurs exception", e);
//        } finally {
//            if (consumer != null) {
//                consumer.close();
//            }
//        }
//        return null;
//    }
//}
