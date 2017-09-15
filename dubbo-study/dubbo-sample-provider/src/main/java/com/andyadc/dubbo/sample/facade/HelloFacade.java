package com.andyadc.dubbo.sample.facade;

import com.andyadc.dubbo.sample.api.HelloService;

/**
 * @author andy.an
 * @since 2017/9/15
 */
public class HelloFacade implements HelloService {

    @Override
    public String hello(String message) {
        return "Hello " + message;
    }
}
