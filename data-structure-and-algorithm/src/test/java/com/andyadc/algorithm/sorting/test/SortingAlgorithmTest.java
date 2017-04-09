package com.andyadc.algorithm.sorting.test;

import com.andyadc.algorithm.sorting.SelectionSort;
import com.andyadc.algorithm.sorting.SortingAlgorithm;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author andaicheng
 * @version 2017/4/9
 */
public class SortingAlgorithmTest {

    @Test
    public void testSelectionSort() {
        SortingAlgorithm sorting = new SelectionSort();
        int[] inputArray = {10, 34, 2, 56, 7, 67, 88, 42};
        System.out.println("input: " + Arrays.toString(inputArray));

        sorting.doSort(inputArray);
        System.out.println("sorted output: " + Arrays.toString(inputArray));
    }
}
