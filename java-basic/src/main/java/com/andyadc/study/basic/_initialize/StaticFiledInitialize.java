package com.andyadc.study.basic._initialize;

/**
 * 被动引用
 *
 * @author andaicheng
 * @version 2017/3/27
 */
public class StaticFiledInitialize {
    public static void main(String[] args) {
        //
        //System.out.println(SubClass.svalue);

        SuperClass[] sc = new SuperClass[10];
    }
}

class SuperClass {
    public static int svalue = 13;

    static {
        System.out.println("SuperClass init!");
    }
}

class SubClass extends SuperClass {
    public static int cvalue = 13;

    static {
        System.out.println("SubClass init!");
    }
}