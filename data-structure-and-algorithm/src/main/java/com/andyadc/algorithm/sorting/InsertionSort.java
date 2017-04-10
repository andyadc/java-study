package com.andyadc.algorithm.sorting;

/**
 * 插入排序
 * 每次排好最终结果数组的一个元素.
 * 它的一般原理是第p次时，将位置p上的元素向左移动，直到它在前p+1个元素中的正确位置被找到.
 *
 * @author andaicheng
 * @version 2017/4/9
 */
public class InsertionSort implements SortingAlgorithm {

    @Override
    public int[] doSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            while (i > 0 && array[i - 1] > temp) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = temp;
        }
        return array;
    }

}
