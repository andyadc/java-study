package com.andyadc.study.basic._static;

/**
 * @author andaicheng
 * @version 2017/3/25
 */
public class Static_Load {

    public static void main(String[] args) {
        new Child();
        System.out.println("------------------------");
        new Child();
    }
}

class Child extends Parent {

    static {
        System.out.println("Child static code block.");
    }

    {
        System.out.println("Child construct code block.");
    }

    Child() {
        System.out.println("Child constructor method.");
    }

}

class Parent {

    static {
        System.out.println("Parent static code block.");
    }

    {
        System.out.println("Parent construct code block.");
    }

    Parent() {
        System.out.println("Parent constructor method.");
    }

}