package com.andyadc.concurrency.basic;

import java.util.concurrent.TimeUnit;

/**
 * 每个线程顺序退出
 *
 * @author andaicheng
 * @version 2017/6/25
 */
public class JoinSeqTest {

    public static void main(String[] args) throws Exception {

        Thread pre = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(pre));
            thread.start();
            pre = thread;
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {

        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
