package com.andyadc.utilities.stopwatch;

import com.google.common.base.Stopwatch;

/**
 * @author andaicheng
 * @version 2017/5/23
 */
public class GuavaStopwatch {

    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        sleep(1);
        stopwatch.stop();
        sleep(2);
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
