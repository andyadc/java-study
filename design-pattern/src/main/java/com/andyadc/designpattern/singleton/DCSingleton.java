package com.andyadc.designpattern.singleton;

/**
 * 双重检查加锁
 * <p>
 * 在java1.4及以前版本中，很多JVM对于volatile关键字的实现的问题，会导致“双重检查加锁”的失败，
 * 因此“双重检查加锁”机制只只能用在java5及以上的版本。
 * <p>
 * <p>
 * 由于volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率并不是很高。因此一般建议，没有特别的需要，不要使用。
 * 也就是说，虽然可以使用“双重检查加锁”机制来实现线程安全的单例，但并不建议大量采用，可以根据情况来选用。
 *
 * @author andaicheng
 * @version 2017/1/14
 */
public class DCSingleton {

    private volatile static DCSingleton instance = null;

    private DCSingleton() {
    }

    public static DCSingleton getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            //同步块，线程安全的创建实例
            synchronized (DCSingleton.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (instance == null) {
                    instance = new DCSingleton();
                }
            }
        }
        return instance;
    }
}
