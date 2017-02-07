package com.andyadc.designpattern.simplefactory.Login;

/**
 * @author andaicheng
 * @version 2017/2/7
 */
public class DomainLogin implements Login {

    @Override
    public boolean verify(String name, String password) {
        /**
         * 业务逻辑
         */
        return false;
    }
}
