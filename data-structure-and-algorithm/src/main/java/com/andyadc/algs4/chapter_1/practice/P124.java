package com.andyadc.algs4.chapter_1.practice;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author andaicheng
 * @version 2017/4/22
 */
public class P124 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = str1;
        str1 = "world";

        StdOut.println(str1); //world
        StdOut.println(str2);//hello
    }
}
