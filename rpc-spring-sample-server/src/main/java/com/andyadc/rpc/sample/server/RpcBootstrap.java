package com.andyadc.rpc.sample.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author andaicheng
 * @version 2017/7/3
 */
public class RpcBootstrap {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    }
}
