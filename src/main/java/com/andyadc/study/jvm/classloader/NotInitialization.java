package com.andyadc.study.jvm.classloader;

/**
 * @author andaicheng
 * @version 2016/11/22
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.a);
    }
}

class SSClass {
    static {
        System.out.println("SSClass");
    }
}

class SuperClass extends SSClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

    public SuperClass () {
        System.out.println("SuperClass construtor");
    }
}

class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }

    static int a;

    public SubClass () {
        System.out.println("SubClass construtor");
    }
}