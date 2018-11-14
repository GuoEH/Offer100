package com.offer.sort;

import com.offer.datastruct.Arrays;

/**
 * 归并排序
 */
public class MergeSort extends Sort {

    private int[] tmp;

    public MergeSort(int capacity) {
        this.tmp = new int[capacity];
    }

    public static void main(String[] args) {
        int[] array = Arrays.createData(20, 50);
        Arrays.print(array);
        Sort sort = new MergeSort(array.length);
        long startTime = System.nanoTime();
        sort.sort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        System.out.println("耗时:" + (endTime - startTime) + "ns");
        Arrays.print(array);
    }

    @Override
    void sort(int[] arr, int start, int end) {
        if (arr == null || arr.length < 2 || start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int left = start;
        int middle = mid + 1;
        int index = start;
        while (left <= mid && middle <= end) {
            if (arr[left] < arr[middle]) {
                tmp[index++] = arr[left++];
            } else {
                tmp[index++] = arr[middle++];
            }
        }
        while (left <= mid) {
            tmp[index++] = arr[left++];
        }
        while (middle <= end) {
            tmp[index++] = arr[middle++];
        }
        for (int i = start; i <= end; i++) {
            arr[i] = tmp[i];
        }
    }
}
