package com.offer.sort;

import com.offer.datastruct.Arrays;

import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort extends Sort{
    public static void main(String[] args) {
        int[] array = Arrays.createData(20, 50);
        Arrays.print(array);
        Sort sort = new QuickSort();
        long startTime = System.nanoTime();
        sort.sort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        System.out.println("耗时:" + (endTime - startTime) + "ns");
        Arrays.print(array);
    }

    @Override
    public void sort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }

        int index = divideArray(array, array.length, start, end);
        if (index > start) {
            sort(array, start, index - 1);
        }
        if (index < end) {
            sort(array, index + 1, end);
        }

    }

    /**
     * 在数组中随机选择一个数字，将数组中小于这个数的移到数组左边，大于这个数的移到数组右边
     *
     * @param array  数组
     * @param length 数组长度
     * @param start  开始位置的索引
     * @param end    结束位置的索引
     * @return 数字的索引
     */
    private int divideArray(int[] array, int length, int start, int end) {
        if (array == null || length <= 0 || start < 0 || end >= length) {
            throw new IllegalArgumentException("参数错误");
        }

        int index = randomRange(start, end);
        swap(array, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (array[index] < array[end]) {
                small++;
                if (small != index) {
                    swap(array, index, small);
                }
            }
        }
        small++;
        swap(array, small, end);
        return small;
    }

    /**
     * 生成一个[start,end]范围内的随机数
     *
     * @param start 左边界
     * @param end   右边界
     * @return 随机数
     */
    private int randomRange(int start, int end) {
        Random random = new Random(System.currentTimeMillis());
        int index = start + random.nextInt((end - start));
        return index;
    }
}
