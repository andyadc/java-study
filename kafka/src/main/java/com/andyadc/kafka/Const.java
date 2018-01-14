package com.andyadc.kafka;

/**
 * @author andy.an
 * @since 2018/1/12
 */
public class Const {

    /**
     * 连接 Zk
     */
    protected static final String ZK_CONNECT = "www.jd-server.com:2181";
    /**
     * 连接 Kafka
     */
    protected static final String BROKER_SERVER = "www.jd-server.com:9092";
    /**
     * session 过期时间
     */
    protected static final int SESSION_TIMEOUT = 30000;
    /**
     * 连接超时时间
     */
    protected static final int CONNECT_TIMEOUT = 30000;
}
