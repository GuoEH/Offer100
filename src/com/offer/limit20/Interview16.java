package com.offer.limit20;

/**
 * Page110:面试题16：数值的整数次方
 */
public class Interview16 {
    public static void main(String[] args) {
        Interview16 interview16 = new Interview16();
        double a = 10;
        int b = -2;
        double result = interview16.pow(a, b);
        System.out.println(a + " 的 " + b + " 次方 = " + result);
    }

    /**
     * 计算a的b次方
     *
     * @param a 底数
     * @param b 幂
     * @return 一个数的整数次幂
     */
    private double pow(double a, int b) {
        if (a == 0L && b < 0) {
            throw new IllegalArgumentException("底数不能为0");
        }
        if (b == 0) {
            return 1L;
        }
        boolean negative = b < 0;
        int absB = Math.abs(b);
        double result = compute(a, absB);
        if (negative) {
            result = 1.0F / result;
        }
        return result;
    }

    /**
     * 计算a的正整数次幂
     *
     * @param a    底数
     * @param absB 幂
     * @return a的正整数次幂
     */
    private double compute(double a, int absB) {
        if (absB == 0) {
            return 1L;
        } else if (absB == 1) {
            return a;
        }
        double result = compute(a, absB >> 1);
        result *= result;
        if ((absB & 0x1) == 1) {
            result *= a;
        }
        return result;
    }
}
