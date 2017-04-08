package com.andyadc.algorithm.sorting;

/**
 * @author andaicheng
 * @version 2017/4/4
 */
public class SelectionSort implements SortingAlgorithm {

    @Override
    public int[] doSort(int[] array) {
        int min;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

        }
        return new int[0];
    }
}
