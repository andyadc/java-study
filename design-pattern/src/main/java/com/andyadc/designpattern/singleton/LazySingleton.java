package com.andyadc.designpattern.singleton;

/**
 * 懒汉式是典型的时间换空间
 *
 * @author andaicheng
 * @version 2017/1/14
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
