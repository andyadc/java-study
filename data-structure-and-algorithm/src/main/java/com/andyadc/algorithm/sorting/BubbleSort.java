package com.andyadc.algorithm.sorting;

/**
 * 冒泡排序
 * 重复地遍历要排序的数组,比较每一对相邻的元素,如果它们次序错误,就把它们进行交换.
 * 它的名字来自这种相对小的元素“上浮”到数组的顶部的方式.
 * 因为它对元素只用到了比较的操作方式，所以是一种比较排序.
 *
 * @author andaicheng
 * @version 2017/4/6
 */
public class BubbleSort implements SortingAlgorithm {

    @Override
    public int[] doSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
