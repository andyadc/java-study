package com.andyadc.algorithm.sorting;

/**
 * 快速排序
 * 它是一种分治的递归算法.它首先把一个大的数组分成两个小的子数组:较小的数的数组和较大的数的数组.
 * 再对这子数组做递归处理。
 * <p>
 * 实现快速排序的步骤：
 * <p>
 * 1.从数组中任意选择一个元素，称为枢纽元（pivot）。虽然无论选择哪个元素作为pivot都可以完成排序，但是有些选择显然优于其他选择。将第一个元素作为pivot是一种错误的做法。安全的做法是随机选取pivot。最好的做法是选择数组的中值：一般的做法是使用左端、右端和中心位置上的三个元素的中值作为pivot。
 * 2.对数组进行重新排序，所有比pivot小的数在pivot前面，所有比pivot大的数在pivot后面（相等的可以在任何一边）。经过这样的分区后，pivot就在它最终的位置上了。这个步骤叫做分区操作。
 * 3.把上述的步骤对含有较小数的子数组和含有较大数的子数组进行递归操作。
 *
 * @author andaicheng
 * @version 2017/4/9
 */
public class QuickSort implements SortingAlgorithm {

    private int[] array;

    @Override
    public int[] doSort(int[] array) {
        this.array = array;
        doQuickSort(this.array, 0, this.array.length - 1);

        return this.array;
    }

    private void doQuickSort(int[] array, int left, int right) {
        int i = left, j = right;
        int pivot = median(array, left, right);
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j)
            doQuickSort(array, left, j);
        if (i < right)
            doQuickSort(array, i, right);
    }


    private int median(int[] array, int left, int right) {
        int center = (left + right) / 2;

        if (array[left] > array[center])
            swap(array, left, center);
        if (array[left] > array[right])
            swap(array, left, right);
        if (array[center] > array[right])
            swap(array, center, right);

        swap(array, center, right - 1);
        return array[right - 1];
    }

    private void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
