package com.andyadc.concurrency.threadstudy;

/**
 * @author andaicheng
 * @version 2017/6/10
 */
public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread.currentThread().isInterrupted();
        Thread.yield();
    }
}
