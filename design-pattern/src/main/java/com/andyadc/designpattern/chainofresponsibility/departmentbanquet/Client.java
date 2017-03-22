package com.andyadc.designpattern.chainofresponsibility.departmentbanquet;

/**
 * @author andaicheng
 * @version 2017/3/21
 */
public class Client {

    public static void main(String[] args) {
        //先要组装责任链
        Handler handler1 = new GeneralManager();
        Handler handler2 = new DeptManager();
        Handler handler3 = new ProjectManager();
        handler3.setSuccessor(handler2);
        handler2.setSuccessor(handler1);

        String test1 = handler3.handleFeeRequest("张三", 300);
        System.out.println("test1 = " + test1);
        String test2 = handler3.handleFeeRequest("李四", 300);
        System.out.println("test2 = " + test2);
        System.out.println("---------------------------------------");

        String test3 = handler3.handleFeeRequest("张三", 700);
        System.out.println("test3 = " + test3);
        String test4 = handler3.handleFeeRequest("李四", 700);
        System.out.println("test4 = " + test4);
        System.out.println("---------------------------------------");

        String test5 = handler3.handleFeeRequest("张三", 1500);
        System.out.println("test5 = " + test5);
        String test6 = handler3.handleFeeRequest("李四", 1500);
        System.out.println("test6 = " + test6);
    }
}
