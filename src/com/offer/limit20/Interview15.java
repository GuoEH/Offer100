package com.offer.limit20;

/**
 * Page100:面试题15：二进制中1的个数
 */
public class Interview15 {
    public static void main(String[] args) {
        Interview15 interview15 = new Interview15();
        int n = 0b11101101;
        int count = interview15.numberOf1(n);
        System.out.println(n + " 的二进制表示中1的个数为 " + count);
        int counts = interview15.numberOf1s(n);
        System.out.println(n + " 的二进制表示中1的个数为 " + counts);
    }

    /**
     * 常规方法计算n的二进制中有几位是1
     *
     * @param n 要求的数字
     * @return 二进制中1的个数
     */
    public int numberOf1(int n) {
        int count = 0;
        int mask = 1;
        while (mask != 0) {
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }

    /**
     * 将原数减1后和原数按位与的方法计算n的二进制中有几位是1
     *
     * @param n 要求的数字
     * @return 二进制中1的个数
     */
    public int numberOf1s(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
