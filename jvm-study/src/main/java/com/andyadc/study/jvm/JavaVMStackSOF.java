package com.andyadc.study.jvm;

/**
 * @author andaicheng
 * @version 2017/3/16
 */
public class JavaVMStackSOF {

    private static int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        //System.out.println("-----" + stackLength);
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + stackLength);
            //throw e;
        }
    }
}
