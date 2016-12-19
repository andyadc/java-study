package com.andyadc.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib proxy
 *
 * @author andaicheng
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        //保存到指定目录
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/temp");

        Man man = (Man) Enhancer.create(ManImpl.class, new CglibProxyIntercepter());
        man.run();
    }
}

class CglibProxyIntercepter implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object ret = proxy.invokeSuper(obj, args);
        after();
        return ret;
    }

    private void before() {
        System.out.println("...before...");
    }

    private void after() {
        System.out.println("...after...");
    }
}


interface Man {
    void run();
}

class ManImpl implements Man {
    @Override
    public void run() {
        System.out.println("the man is running...");
    }
}
