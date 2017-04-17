package com.andyadc.algorithm.sorting.test;

import com.andyadc.algorithm.sorting.BubbleSort;
import com.andyadc.algorithm.sorting.InsertionSort;
import com.andyadc.algorithm.sorting.QuickSort;
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
    public void testQuickSort() {
        SortingAlgorithm sorting = new QuickSort();
        int[] inputArray = {10, 34, 2, 56, 7, 67, 0, 88, 42};
        System.out.println("input: " + Arrays.toString(inputArray));

        sorting.doSort(inputArray);
        System.out.println("sorted output: " + Arrays.toString(inputArray));
    }

    @Test
    public void testInsertionSort() {
        SortingAlgorithm sorting = new InsertionSort();
        int[] inputArray = {10, 34, 2, 56, 7, 67, 0, 88, 42};
        System.out.println("input: " + Arrays.toString(inputArray));

        sorting.doSort(inputArray);
        System.out.println("sorted output: " + Arrays.toString(inputArray));
    }

    @Test
    public void testSelectionSort() {
        SortingAlgorithm sorting = new SelectionSort();
        int[] inputArray = {10, 34, 2, 56, 7, 67, 0, 88, 42};
        System.out.println("input: " + Arrays.toString(inputArray));

        sorting.doSort(inputArray);
        System.out.println("sorted output: " + Arrays.toString(inputArray));
    }

    @Test
    public void testBubbleSort() {
        SortingAlgorithm sorting = new BubbleSort();
        int[] inputArray = {10, 34, 2, 56, 7, 67, 0, 88, 42};
        System.out.println("input: " + Arrays.toString(inputArray));

        sorting.doSort(inputArray);
        System.out.println("sorted output: " + Arrays.toString(inputArray));
    }

}
