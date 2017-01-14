package com.andyadc.designpattern.singleton;

/**
 * 经典单例模式
 *
 * @author andaicheng
 * @version 2017/1/14
 */
public class Singleton {

    private static Singleton uniqeInstance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqeInstance == null) {
            uniqeInstance = new Singleton();
        }
        return uniqeInstance;
    }
}
