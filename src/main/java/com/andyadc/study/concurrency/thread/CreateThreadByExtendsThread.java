package com.andyadc.study.concurrency.thread;

/**
 * @author andaicheng
 * @version 2016/10/26
 */
public class CreateThreadByExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " I'm extends Thread!");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " main");
        Thread thread = new CreateThreadByExtendsThread();
        thread.start();
        thread.start();
    }
}
