package com.andyadc.concurrency.basic;

/**
 * @author andy.an
 * @since 2017/9/21
 */
public class TestJoin {

    public static void main(String[] args) throws Exception {

        Thread myThread = new Thread(new MyThread(), "mythread");
        myThread.start();
        //myThread.join();
        //System.out.println("---main----");
    }

    static class MyThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
        }
    }

}
