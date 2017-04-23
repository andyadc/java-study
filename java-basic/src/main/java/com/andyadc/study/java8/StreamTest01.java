package com.andyadc.study.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author andaicheng
 * @version 2017/4/23
 */
public class StreamTest01 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("love", "master", "version", "7eleven");
        before8(list);
        after8(list);
        upCaseAfter8(list);
    }

    private static void after8(List<String> list) {
        list.stream().filter(s -> Character.isDigit(s.charAt(0))).forEach(s -> System.out.println(s));
    }

    private static void upCaseAfter8(List<String> list) {
        Set<String> strings = list.stream().filter(s -> !Character.isDigit(s.charAt(0))).map(String::toUpperCase).collect(Collectors.toSet());

        strings.forEach(s -> System.out.println(s));
    }

    private static void before8(List<String> list) {
        for (String s : list) {
            if (Character.isDigit(s.charAt(0)))
                System.out.println(s);
        }
    }
}
