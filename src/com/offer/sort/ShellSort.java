package com.offer.sort;

import com.offer.datastruct.Arrays;

/**
 * 希尔排序
 */
public class ShellSort extends Sort {
    public static void main(String[] args) {
        int[] array = Arrays.createData(20, 50);
        Arrays.print(array);
        Sort sort = new ShellSort();
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
        int len = arr.length;
        int tmp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                tmp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > tmp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = tmp;
            }
            gap /= 2;
        }
    }
}
