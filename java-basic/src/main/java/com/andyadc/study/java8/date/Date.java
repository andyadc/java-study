package com.andyadc.study.java8.date;

import java.time.LocalDate;

/**
 * @author andaicheng
 * @since 2017/11/26
 */
public class Date {

    public static void main(String[] args) {
        // 不可变
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate.plusDays(1);
        System.out.println(localDate);
    }
}
