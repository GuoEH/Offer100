package com.offer.limit20;

import java.math.BigInteger;

/**
 * Page114:面试题17:打印从1到最大的n位数
 */
public class Interview17 {
    public static void main(String[] args) {
        Interview17 interview17 = new Interview17();
        int n = 3;
        interview17.printMaxNDigits(n);
    }

    /**
     * 打印从1到最大的n位数
     * @param n n位树
     */
    public void printMaxNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            printMaxNDigitsRecursively(number, n, 0);
        }

    }

    private void printMaxNDigitsRecursively(char[] number, int n, int index) {
        if (index == (n - 1)) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            printMaxNDigitsRecursively(number, n, index + 1);
        }
    }

    private void printNumber(char[] number) {
        boolean isStart0 = true;
        int len = number.length;
        for (int i = 0; i < len; i++) {
            if (isStart0 && number[i] != '0') {
                isStart0 = false;
            }
            if (!isStart0) {
                System.out.print(number[i]);
            }
        }
        System.out.print('\t');
    }
}
