package com.offer.sort;

import com.offer.datastruct.Arrays;

/**
 * 插入排序
 */
public class InsertionSort extends Sort {
    public static void main(String[] args) {
        int[] array = Arrays.createData(20, 50);
        Arrays.print(array);
        Sort sort = new InsertionSort();
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
        int current;
        for (int i = 0; i < end; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }
}
