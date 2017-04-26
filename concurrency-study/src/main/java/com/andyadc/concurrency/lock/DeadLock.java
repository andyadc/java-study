package com.andyadc.concurrency.lock;

/**
 * this code definitely dead lock
 *
 * @author andaicheng
 * @version 2017/4/26
 */
public class DeadLock {

    private static final Object object1 = new Object();
    private static final Object object2 = new Object();

    public static void main(String[] args) {
        Thread thread01 = new Thread(new Dead01(), "DeadLock-01");
        Thread thread02 = new Thread(new Dead02(), "DeadLock-02");

        thread01.start();
        thread02.start();
    }

    static class Dead01 implements Runnable {

        @Override
        public void run() {
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + " get lock (object1)");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (object2) {
                    System.out.println(Thread.currentThread().getName() + " get lock (object2)");
                }
            }
        }
    }

    static class Dead02 implements Runnable {

        @Override
        public void run() {
            synchronized (object2) {
                System.out.println(Thread.currentThread().getName() + " get lock (object2)");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (object1) {
                    System.out.println(Thread.currentThread().getName() + " get lock (object1)");
                }
            }
        }
    }

}

