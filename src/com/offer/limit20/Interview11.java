package com.offer.limit20;

import com.offer.datastruct.Arrays;

import java.util.Random;

/**
 * Page82:面试题11：旋转数组的最小数字
 */
public class Interview11 {
    public static void main(String[] args) {
        Interview11 interview11 = new Interview11();
        int[] array = interview11.createData(20);
        Arrays.print(array);
        int min = interview11.findMin(array);
        System.out.println("最小值是:" + min);
    }

    public int[] createData(int length) {
        int[] array = new int[length];
        Random random = new Random(System.currentTimeMillis());
        int last = 0;
        int range = 10;
        int index = random.nextInt(length);
        System.out.println("index = [" + index + "]");
        for (int i = index; i < length; i++) {
            array[i] = random.nextInt(range) + last + 1;
            last = array[i];
        }
        for (int i = 0; i < index; i++) {
            array[i] = random.nextInt(range) + last + 1;
            last = array[i];
        }
        return array;
    }

    public int findMin(int[] array) {
        int left = 0;
        int right = array.length-1;
        int mid = left;
        while (array[left] >= array[right]){
            if (right-left == 1){
                mid = right;
                break;
            }
            mid = left + (right-left)/2;
            if (array[left] == array[right] && array[mid] == array[left]){
                return minInOrder(array,left,right);
            }
            if (array[mid] >= array[left]){
                left = mid;
            }else if (array[mid] <= array[right]){
                right = mid;
            }
        }
        return array[mid];
    }

    private int minInOrder(int[] array, int left, int right) {
        int result = array[left];
        for (int i = left+1; i < right; i++) {
            if (result>array[i]){
                result = array[i];
            }
        }
        return result;
    }
}
