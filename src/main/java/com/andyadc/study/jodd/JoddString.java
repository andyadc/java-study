package com.andyadc.study.jodd;

import jodd.util.StringUtil;

/**
 * @author andaicheng
 * @version 2016/11/18
 */
public class JoddString {

    public static void main(String[] args) {
        System.out.println(StringUtil.repeat("a", 4));
        System.out.println(StringUtil.replaceLast("abcdefg", "cd", "xy"));
        System.out.println(StringUtil.capitalize("abc"));
    }
}
