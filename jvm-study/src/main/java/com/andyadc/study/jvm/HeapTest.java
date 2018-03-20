package com.andyadc.study.jvm;

/**
 * VM options:
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -verbose:gc
 * -XX:+PrintGCDetails
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCTimeStamps
 *
 * @author andy.an
 * @since 2018/3/20
 */
public class HeapTest {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        System.out.println("...");
        byte[] bytes1 = new byte[2 * _1M];
        byte[] bytes2 = new byte[2 * _1M];
        byte[] bytes3 = new byte[2 * _1M];
        byte[] bytes4 = new byte[2 * _1M];
        byte[] bytes5 = new byte[2 * _1M];
        byte[] bytes6 = new byte[5 * _1M];
        byte[] bytes7 = new byte[2 * _1M];
    }
}
