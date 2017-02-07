package com.andyadc.designpattern.simplefactory.Login;

/**
 * @author andaicheng
 * @version 2017/2/7
 */
public interface Login {

    //登录验证
    boolean verify(String name, String password);
}
