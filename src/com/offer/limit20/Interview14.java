package com.offer.limit20;

import com.offer.datastruct.Arrays;

/**
 * Page96:面试题14：剪绳子
 * dynamic programming 动态规划
 * greedy algorithm 贪婪算法
 */
public class Interview14 {
    public static void main(String[] args) {
        Interview14 interview14 = new Interview14();
        int maxDp = interview14.maxLenMulDP(10, 2);
        System.out.println("动态规划：最大乘积为 = " + maxDp);
        int maxGa = interview14.maxLenMulGA(10, 2);
        System.out.println("贪婪算法：最大乘积为 = " + maxGa);
    }

    /**
     * 动态规划算法计算
     *
     * @param ropeLength 绳子长度
     * @param n          剪的次数
     * @return 最大乘积
     */
    public int maxLenMulDP(int ropeLength, int n) {
        //TODO：结果不正确
        if (ropeLength < n || ropeLength < 2 || n < 2) {
            throw new IllegalArgumentException("参数错误");
        }
        if (ropeLength == 2) {
            return 1;
        } else if (ropeLength == 3) {
            return 2;
        }
        int[] ropes = new int[ropeLength + 1];
        ropes[0] = 0;
        ropes[1] = 1;
        ropes[2] = 2;
        ropes[3] = 3;
        int max = 0;
        for (int i = 4; i <= ropeLength; i++) {
            max = 0;
            for (int j = 1; j < i / 2; j++) {
                int rope = ropes[j] * ropes[i - j];
                if (max < rope) {
                    max = rope;
                }
                ropes[i] = max;
                System.out.println();
            }
        }
        max = ropes[n];
        Arrays.print(ropes);
        return max;
    }

    public int maxLenMulGA(int ropeLength, int n) {
        if (ropeLength < n || ropeLength < 2 || n < 2) {
            throw new IllegalArgumentException("参数错误");
        }
        if (ropeLength == 2) {
            return 1;
        } else if (ropeLength == 3) {
            return 2;
        }
        int timesOf3 = ropeLength / 3;
        if ((ropeLength - timesOf3 * 3) == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (ropeLength - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }
}
