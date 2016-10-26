package com.andyadc.study.concurrency.thread;

/**
 * @author andaicheng
 * @version 2016/10/26
 */
public class CreateThreadByImplementsRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " I'm implements Runnable!");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " main");
        new Thread(new CreateThreadByImplementsRunnable()).start();
    }
}
