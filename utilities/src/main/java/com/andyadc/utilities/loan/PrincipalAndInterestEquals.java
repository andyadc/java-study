package com.andyadc.utilities.loan;

import java.math.BigDecimal;

/**
 * @author andaicheng
 * @version 2017/1/21
 */
public class PrincipalAndInterestEquals {

    public static void main(String[] args) {
        BigDecimal invest = new BigDecimal(100000); // 本金
        double yearRate = 0.12; // 年利率
        double monthRate = yearRate / 12;
        int month = 6;

        // 每月本息金额  = (本金×月利率×(1＋月利率)＾还款月数)÷ ((1＋月利率)＾还款月数-1)
        BigDecimal monthIncome = invest.multiply(BigDecimal.valueOf(monthRate * Math.pow(1 +
                monthRate, month))).divide(BigDecimal.valueOf(Math.pow(1 + monthRate, month) - 1), 2,
                BigDecimal.ROUND_HALF_UP);
        System.out.println("每月本息金额 : " + monthIncome);

        System.out.println("---------------------------------------------------");

        // 每月本金 = 本金×月利率×(1+月利率)^(还款月序号-1)÷((1+月利率)^还款月数-1)
        BigDecimal monthCapital;
        BigDecimal sumCapital = BigDecimal.ZERO;
        for (int i = 1; i < month + 1; i++) {
            monthCapital = invest.multiply(BigDecimal.valueOf(monthRate * (Math.pow(1 + monthRate,
                    i - 1)))).divide(BigDecimal.valueOf(Math.pow(1 + monthRate, month) - 1), 2,
                    BigDecimal.ROUND_HALF_UP);
            System.out.println("第" + i + "月本金： " + monthCapital);
            sumCapital = sumCapital.add(monthCapital);
        }

        System.out.println("---------------------------------------------------");

        // 每月利息  = 剩余本金 x 贷款月利率
        BigDecimal monthInterest;
        BigDecimal capital = invest;
        BigDecimal tmpCapital = BigDecimal.ZERO;
        BigDecimal sumInterest = BigDecimal.ZERO;
        for (int i = 1; i < month + 1; i++) {
            capital = capital.subtract(tmpCapital);
            monthInterest = capital.multiply(BigDecimal.valueOf(monthRate)).setScale(2, BigDecimal
                    .ROUND_HALF_UP);
            tmpCapital = invest.multiply(BigDecimal.valueOf(monthRate * (Math.pow((1 + monthRate), i
                    - 1)))).divide(BigDecimal.valueOf(Math.pow(1 + monthRate, month) - 1), 2,
                    BigDecimal.ROUND_HALF_UP);
            System.out.println("第" + i + "月利息： " + monthInterest);

            sumInterest = sumInterest.add(monthInterest);
        }
        System.out.println("本金总和：" + sumCapital + " 利息总和：" + sumInterest);
    }
}
