package com.andyadc.algorithm.sorting;

/**
 * 选择排序
 * 在未排序序列中找到最小或是最大的元素,存放到排序序列的起始位置;
 * 然后再从剩余的未排序的元素中继续寻找最小或是最大的元素.
 * 这样子持续进行下去,直到所有的元素排好顺序.
 *
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
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }

}
