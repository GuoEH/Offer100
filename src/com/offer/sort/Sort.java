package com.offer.sort;

/**
 * 排序.https://www.cnblogs.com/guoyaohua/p/8600214.html
 */
public abstract class Sort {
    abstract void sort(int[] arr, int start, int end);

    /**
     * 交换数组的两个位置
     *
     * @param array  数组
     * @param index1 第一个位置
     * @param index2 第二个位置
     */
    protected void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
