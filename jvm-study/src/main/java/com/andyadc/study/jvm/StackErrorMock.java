package com.andyadc.study.jvm;

/**
 * @author andaicheng
 * @version 2017/6/22
 */
public class StackErrorMock {

    private static int index = 1;

    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        } catch (Throwable e) {
            System.out.println("Stack deep : " + index);
            e.printStackTrace();
        }
    }
}
