package com.andyadc.thrift.service;

import com.andyadc.thrift.dto.User;
import com.andyadc.thrift.dto.UserReq;
import org.apache.thrift.TException;

import java.util.Arrays;
import java.util.List;

/**
 * @author andy.an
 * @since 2017/10/7
 */
public class HelloServiceImpl implements HelloService.Iface {

    @Override
    public String ping() throws TException {
        return "pong";
    }

    @Override
    public List<User> getUserList(UserReq req) throws TException {
        User user = new User();
        user.setAge((short) 12);
        user.setName("andy");
        return Arrays.asList(user);
    }
}
