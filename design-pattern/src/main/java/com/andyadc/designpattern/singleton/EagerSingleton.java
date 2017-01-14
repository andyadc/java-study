package com.andyadc.designpattern.singleton;

/**
 * 饿汉式是典型的空间换时间
 *
 * @author andaicheng
 * @version 2017/1/14
 */
public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public EagerSingleton getInstance() {
        return instance;
    }
}
