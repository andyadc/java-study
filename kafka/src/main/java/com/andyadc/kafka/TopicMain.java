package com.andyadc.kafka;

import kafka.admin.AdminUtils;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;

import java.util.Properties;

import static com.andyadc.kafka.Const.*;

/**
 * @author andy.an
 * @since 2018/1/12
 */
public class TopicMain {

    private static final String TOPIC_TEST = "test";

    public static void main(String[] args) {
        Properties properties = new Properties();
//        createTopic(TOPIC_TEST, 1, 1, properties);

        deleteToic(TOPIC_TEST);
    }

    public static void deleteToic(String topic) {
        ZkUtils zkUtils = null;
        try {
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT, CONNECT_TIMEOUT,
                    JaasUtils.isZkSecurityEnabled());
            AdminUtils.deleteTopic(zkUtils, topic);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zkUtils != null) {
                zkUtils.close();
            }
        }
    }

    /**
     * 修改主题级别配置
     *
     * @param topic
     * @param properties
     */
    public static void modifyTopicConfig(String topic, Properties properties) {
        ZkUtils zkUtils = null;
        try {
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT, CONNECT_TIMEOUT,
                    JaasUtils.isZkSecurityEnabled());
            // 首先获取当前已有的配置，这里是查询主题级别的配置，因此指定配置类型为 Topic
            Properties curProp = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), topic);
            curProp.putAll(properties);// 添加新修改的配置
            AdminUtils.changeTopicConfig(zkUtils, topic, curProp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zkUtils != null) {
                zkUtils.close();
            }
        }
    }

    /**
     * 创建主题
     *
     * @param topic
     * @param partition
     * @param replication
     * @param properties
     */
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
