package com.andyadc.study.concurrency.volatiletest;

/**
 * @author andaicheng
 */
public class VolatileTest {

    private static volatile int race = 0;
    private static final int THREAD_COUNT = 20;

    public static void increase() {
        race++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        increase();
                    }
                }
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("result: " + race);
    }
}
