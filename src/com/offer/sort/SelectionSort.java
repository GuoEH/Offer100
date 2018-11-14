package com.offer.sort;

import com.offer.datastruct.Arrays;

/**
 * 选择排序
 */
public class SelectionSort extends Sort {
    public static void main(String[] args) {
        int[] array = Arrays.createData(20, 50);
        Arrays.print(array);
        Sort sort = new SelectionSort();
        long startTime = System.nanoTime();
        sort.sort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        System.out.println("耗时:" + (endTime - startTime) + "ns");
        Arrays.print(array);
    }

    @Override
    void sort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start == end) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
}