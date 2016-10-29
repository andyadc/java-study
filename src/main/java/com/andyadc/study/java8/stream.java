package com.andyadc.study.java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java8新特性-流式数据处理
 *
 * @author andaicheng
 */
public class stream {

    private static final Logger LOGGER = LoggerFactory.getLogger(stream.class);

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6, 8, 9));
        getList(nums);
        getListByStream(nums);
    }

    public static void getListByStream(List<Integer> nums){
        List<Integer> evens = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        LOGGER.info("{}", evens);
    }

    private static void getList(List<Integer> nums) {
        List<Integer> evens = new ArrayList<>();
        for (Integer num : nums) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        LOGGER.info("{}", evens);
    }

}
