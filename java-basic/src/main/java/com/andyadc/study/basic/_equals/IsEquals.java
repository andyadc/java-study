package com.andyadc.study.basic._equals;

/**
 * 不能轻易的说equals就是比较内容的，其行为是特定于实现的
 * <url>http://www.ticmy.com/?p=186</url>
 *
 * @author andaicheng
 * @version 2017/5/6
 */
public class IsEquals {

    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = new String("aaa");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println("----------------------------");

        StringBuilder sb1 = new StringBuilder("bbb");
        StringBuilder sb2 = new StringBuilder("bbb");
        System.out.println(sb1 == sb2); //false
        System.out.println(sb1.equals(sb2)); //false
    }
}
