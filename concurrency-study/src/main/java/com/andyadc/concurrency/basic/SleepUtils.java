package com.andyadc.concurrency.basic;

import java.util.concurrent.TimeUnit;

/**
 * @author andaicheng
 * @version 2017/7/27
 */
public class SleepUtils {

    public static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
