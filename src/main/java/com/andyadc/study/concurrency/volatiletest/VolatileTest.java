package com.andyadc.study.concurrency.volatiletest;

/**
 * @author andaicheng
 * @version 2016/11/14
 */
public class VolatileTest {

    public static volatile int race = 0;
    private static final int THREAD_COUNT = 20;

    public static void increase() {
        race++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }

        //while (Thread.activeCount() > 1)

        System.out.println(race);
    }
}
