package com.offer;

import java.util.Random;

/**
 * Page39:面试题3：数组中重复的数字
 */
public class Interview3 {
    public static void main(String[] args) {

        Interview3 interview3 = new Interview3();
        int length = 10;
        int[] numners = new int[length];
        interview3.createData(length, numners);
        int duplicate1 = interview3.duplicateNoEdit(numners, length);
        System.out.println("重复的数字是：" + duplicate1);
        int duplicate = interview3.duplicate(numners, length);
        System.out.println("重复的数字是：" + duplicate);
    }

    /**
     * 题目一：找出数组中重复的数字。时间复杂度为O(n),空间复杂度为O(1)
     *
     * @param numbers 数组
     * @param length  数组长度
     * @return 没有找到-1;找到则返回首个找到的重复的数字
     */
    public int duplicate(int[] numbers, int length) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return -1;
            }
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
                printArray(numbers);
            }
        }
        return -1;
    }

    /**
     * 题目二：找出数组中重复的数字，但不能修改原数组。时间复杂度为O(nlogn),空间复杂度为O(1)
     *
     * @param numbers 数组
     * @param length  数组长度
     * @return 没有找到-1;找到则返回首个找到的重复的数字
     */
    public int duplicateNoEdit(int[] numbers, int length) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return -1;
            }
        }

        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int middle = start + ((end - start) >> 1);
            System.out.print("查找区间为[" + start + "," + middle + "]");
            int count = count(numbers, length, start, middle);
            System.out.println("找到"+count+"个");
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                System.out.println("在区间[" + start + "," + middle + "]内");
                end = middle;
            } else {
                System.out.println("在区间[" + (middle + 1) + "," + end + "]内");
                start = middle + 1;
            }
        }
        return -1;
    }

    private int count(int[] numbers, int length, int start, int end) {
        if (numbers == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                ++count;
            }
        }
        return count;
    }

    public void createData(int length, int[] numbers) {
        Random random = new Random(System.currentTimeMillis());
        System.out.println("array>>>");
        System.out.println("0|1|2|3|4|5|6|7|8|9");
        for (int i = 0; i < length; i++) {
            numbers[i] = random.nextInt(length);
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\n<<<end");
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
