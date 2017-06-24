package com.andyadc.study.reflection;

/**
 * @author andaicheng
 * @version 2017/6/4
 */
public class TestGetClass {

    public TestGetClass() {
        System.out.println("constructor");
    }

    public static void main(String[] args) throws Exception {
        Class clz = TestGetClass.class;
        System.out.println(clz.newInstance());

        System.out.println("----------------------");

        Class clz1 = new TestGetClass().getClass();
        System.out.println(clz1.newInstance());

        System.out.println("----------------------");

        Class clz2 = Class.forName("com.andyadc.study.reflection.TestGetClass");
        System.out.println(clz2.newInstance());


    }
}
