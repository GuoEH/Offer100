package com.offer.sort;

import com.offer.datastruct.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort extends Sort {
    public static void main(String[] args) {
        int[] array = Arrays.createData(20, 50);
        Arrays.print(array);
        Sort sort = new BubbleSort();
        long startTime = System.nanoTime();
        sort.sort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        System.out.println("耗时:" + (endTime - startTime) + "ns");
        Arrays.print(array);
    }

    @Override
    public void sort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start == end) {
            return;
        }
        for (int i = 0; i < end; i++) {
            for (int j = 0; j < end - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
