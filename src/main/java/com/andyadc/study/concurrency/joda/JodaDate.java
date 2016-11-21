package com.andyadc.study.concurrency.joda;

import org.joda.time.DateTime;

/**
 * @author andaicheng
 * @version 2016/11/18
 */
public class JodaDate {

    public static void main(String[] args) {
        DateTime dateTime = new DateTime(2016, 12, 1, 15, 23, 24);
        System.out.println(dateTime.toLocalDate());
    }
}
