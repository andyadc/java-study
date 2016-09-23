package com.andyadc.study.proxy.cglib;

import net.sf.cglib.proxy.Mixin;

import java.lang.reflect.Method;

/**
 * 将多个接口混合在一起的方式, 实现了多个接口
 *
 * @author andaicheng
 */
public class MixinTest {

    public static void main(String[] args) {
        Class<?>[] interfaces = {MyInterface1.class, MyInterface2.class};
        Object[] delegates = {new MyInterface1Impl(), new MyInterface2Impl()};

        //Minix组合为o对象。
        Object o = Mixin.create(interfaces, delegates);

        MyInterface1 interface1 = (MyInterface1) o;
        MyInterface2 interface2 = (MyInterface2) o;
        interface1.a();
        interface2.b();

        Method[] methods = o.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }


}

interface MyInterface1 {
    void a();
}

interface MyInterface2 {
    void b();
}

class MyInterface1Impl implements MyInterface1 {

    @Override
    public void a() {
        System.out.println("-------a--------");
    }
}

class MyInterface2Impl implements MyInterface2 {

    @Override
    public void b() {
        System.out.println("-------b---------");
    }
}