package com.andyadc.concurrency.lock;

/**
 * 死锁范列
 */
public class DefinatelyDeadLock {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(new DeadLock(lock1, lock2), "lock1");
        Thread thread2 = new Thread(new DeadLock(lock2, lock1), "lock2");

        thread1.start();
        thread2.start();
    }

    static class DeadLock implements Runnable {

        private final Object lock1;
        private final Object lock2;

        public DeadLock(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            synchronized (lock1) {
                sleep(3);
                synchronized (lock2) {
                }
            }
        }

        private void sleep(int seconds) {
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
