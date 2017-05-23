package com.andyadc.utilities.stopwatch;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author andaicheng
 * @version 2017/5/23
 */
public class CommonsStopWatch {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sleep(1);
        stopWatch.split();
        sleep(2);
        stopWatch.stop();
        //System.out.println(stopWatch.toString());
        System.out.println(stopWatch.toSplitString());
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
