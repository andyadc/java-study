package com.andyadc.study.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 去重后排序
 */
public class SortAndDeleteDuplicate {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 4, 2, 0, -1, 5, 10, 8, 2);
        List<Integer> list2 = Arrays.asList(10, 14, 2, 3, -1, 5);

        sortAndDeleteDuplicate(list1, list2);
    }

    private static List<Integer> sortAndDeleteDuplicate(final List<Integer> list1, final List<Integer> list2) {
        Set<Integer> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);

        List<Integer> newList = new ArrayList<>();
        newList.addAll(set);

        Collections.sort(newList, (o1, o2) -> o1 - o2);
        return newList;
    }
}
