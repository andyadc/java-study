package com.andyadc.kafka;

import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;

import java.util.Properties;

import static com.andyadc.kafka.KafkaCommon.*;

/**
 * @author andy.an
 * @since 2018/1/12
 */
public class KafkaTopic {

    public static void main(String[] args) {
        createTopic("test", 1, 1, null);
    }

    public static void createTopic(String topic, int partition, int replication, Properties properties) {
        ZkUtils zkUtils = null;
        try {
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT, CONNECT_TIMEOUT,
                    JaasUtils.isZkSecurityEnabled());
            if (!AdminUtils.topicExists(zkUtils, topic)) {
                AdminUtils.createTopic(zkUtils, topic, partition, replication, properties,
                        AdminUtils.createTopic$default$6());
            } else {
                System.out.println(topic + " is existed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zkUtils != null) {
                zkUtils.close();
            }
        }
    }

}
