package com.andyadc.designpattern.singleton;

/**
 * 使用枚举来实现单实例控制会更加简洁，而且无偿地提供了序列化机制，
 * 并由JVM从根本上提供保障，绝对防止多次实例化，是更简洁、高效、安全的实现单例的方式。
 *
 * @author andaicheng
 * @version 2017/1/14
 */
public enum EnumSingleton {

    /**
     * 定义一个枚举的元素，它就代表了EnumSingleton的一个实例。
     */
    uniqueInstance;

    /**
     * 单例可以有自己的操作
     */
    public void operation() {
        //...
    }
}
