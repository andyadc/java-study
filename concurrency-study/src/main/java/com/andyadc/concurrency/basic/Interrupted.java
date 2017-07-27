package com.andyadc.concurrency.basic;

import java.util.concurrent.TimeUnit;

/**
 * @author andaicheng
 * @version 2017/7/27
 */
public class Interrupted {

    public static void main(String[] args) throws Exception {

        Thread sleepThread = new Thread(new SleepRunner(), "sleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "busyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        SleepUtils.sleep(2);
    }

    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.sleep(10);
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
            }
        }
    }

}
