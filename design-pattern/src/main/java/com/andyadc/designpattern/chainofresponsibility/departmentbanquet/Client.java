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
        handler2.setSuccessor(handler2);
        handler1.setSuccessor(handler1);

        String test1 = handler3.handleFeeRequest("张三", 300);
    }
}
