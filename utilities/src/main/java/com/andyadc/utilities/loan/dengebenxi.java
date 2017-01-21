package com.andyadc.utilities.loan;

import java.math.BigDecimal;

/**
 * @author andaicheng
 * @version 2017/1/21
 */
public class dengebenxi {

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        BigDecimal priciple = principle(100000D, 0.12D, 6D);
        System.out.println(priciple);
        System.out.println(BigDecimal.valueOf(100000D).subtract(priciple).multiply(BigDecimal.valueOf(0.12)).divide(BigDecimal.valueOf(360), 2).multiply(BigDecimal.valueOf(150)));
        System.out.println(System.currentTimeMillis() - l1);
    }

    private static BigDecimal principle(double amount, double rate, double limit) {
        double monthRate = rate / 12;
        double x = Math.pow(1 + monthRate, limit);
        double y = amount * monthRate * x;
        double z = x - 1;

        return BigDecimal.valueOf(y).divide(BigDecimal.valueOf(z), 2, BigDecimal.ROUND_HALF_UP);
    }
}
