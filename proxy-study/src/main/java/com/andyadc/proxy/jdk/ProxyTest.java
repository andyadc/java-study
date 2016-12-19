package com.andyadc.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author andaicheng
 */
public class ProxyTest extends Proxy {

    public static void main(String[] args) throws Throwable {
        new ProxyTest(new DynamicHandler(new DynamicImpl())).eat("banana");
    }

    private static Method playMethod;
    private static Method eatMethod;

    static {
        try {
            playMethod = Class.forName("com.andyadc.study.proxy.jdk.Dynamic").getMethod("play", new Class[0]);
            eatMethod = Class.forName("com.andyadc.study.proxy.jdk.Dynamic").getMethod("eat", new Class[]{Class.forName("java.lang.String")});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected ProxyTest(InvocationHandler h) {
        super(h);
    }

    public void play() throws Throwable {
        this.h.invoke(this, playMethod, null);
    }

    public boolean eat(Object o) throws Throwable {
        return (boolean) this.h.invoke(this, eatMethod, new Object[]{o});
    }
}
