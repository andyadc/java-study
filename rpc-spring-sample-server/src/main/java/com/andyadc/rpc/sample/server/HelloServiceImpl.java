package com.andyadc.rpc.sample.server;

import com.andyadc.rpc.RpcService;
import com.andyadc.rpc.sample.api.HelloService;

/**
 * @author andaicheng
 * @version 2017/7/3
 */
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
