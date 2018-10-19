package com.offer.limit20;

import java.math.BigInteger;

/**
 * Page74:面试题10：斐波那契数列&青蛙跳阶问题
 */
public class Interview10 {
    public static void main(String[] args) {
        Interview10 interview10 = new Interview10();
        System.out.println(interview10.fibonacci(0).toString());
        System.out.println(interview10.fibonacci(1).toString());
        System.out.println(interview10.fibonacci(2).toString());

        System.out.println(interview10.fibonacci(100).toString());
        System.out.println(interview10.fibonacci(1000).toString());
        System.out.println(interview10.fibonacci(10000).toString());

        System.out.println(interview10.fibonacciMatrix(100).toString());
        System.out.println(interview10.fibonacciMatrix(1000).toString());
        System.out.println(interview10.fibonacciMatrix(10000).toString());
    }

    /**
     * 求取Fibonacci的第n项，时间复杂度为O(n)
     *
     * @param n 第n项
     * @return Fibonacci第n项值
     */
    BigInteger fibonacci(int n) {
        long start = System.nanoTime();
        BigInteger[] result = {BigInteger.ZERO, BigInteger.ONE};
        if (n < 2) {
            return result[n];
        }
        BigInteger fib1 = BigInteger.ZERO;
        BigInteger fib2 = BigInteger.ONE;
        BigInteger fibN = null;
        for (int i = 2; i <= n; i++) {
            fibN = fib1.add(fib2);
            fib2 = fib1;
            fib1 = fibN;
        }
        long end = System.nanoTime();
        System.out.println("循环:" + n + ":耗时:" + (end - start) + "ns");
        return fibN;
    }

    /**
     * 求取Fibonacci的第n项，时间复杂度为O(logn)
     *
     * @param n 第n项
     * @return Fibonacci第n项值
     */
    BigInteger fibonacciMatrix(int n) {
        long start = System.nanoTime();
        BigInteger[] result = {BigInteger.ZERO, BigInteger.ONE};
        if (n < 2) {
            return result[n];
        }
        Matrix2By2 fibN = new Matrix2By2().pow(n - 1);
        long end = System.nanoTime();
        System.out.println("矩阵:" + n + ":耗时:" + (end - start) + "ns");
        return fibN.m00;
    }

    class Matrix2By2 {
        public BigInteger m00, m01, m10, m11;

        public Matrix2By2() {
        }

        public Matrix2By2(BigInteger m00, BigInteger m01, BigInteger m10, BigInteger m11) {
            this.m00 = m00;
            this.m01 = m01;
            this.m10 = m10;
            this.m11 = m11;
        }

        public Matrix2By2 mul(Matrix2By2 a, Matrix2By2 b) {
            return new Matrix2By2((a.m00.multiply(b.m00)).add(a.m01.multiply(b.m10))
                    , (a.m00.multiply(b.m01)).add(a.m01.multiply(b.m11))
                    , (a.m10.multiply(b.m00)).add(a.m11.multiply(b.m10))
                    , (a.m10.multiply(b.m01)).add(a.m11.multiply(b.m11)));
        }

        public Matrix2By2 pow(int n) {
            assert n > 0;
            Matrix2By2 result = null;
            if (n == 1) {
                result = new Matrix2By2(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO);
            } else if (n % 2 == 0) {
                result = pow(n / 2);
                result = mul(result, result);
            } else if (n % 2 == 1) {
                result = pow((n - 1) / 2);
                result = mul(result, result);
                result = mul(result, new Matrix2By2(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO));
            }
            return result;
        }
    }

    public int frogStep(int n) {
        if (n < 1) {
            return 0;
        }
        int[] steps = {1, 2};
        if (n < 3) {
            return steps[n];
        }
        int stepN = 0;
        int stepN_1 = 1;
        int stepN_2 = 2;
        for (int i = 3; i < n; i++) {
            stepN = stepN_1 + stepN_2;
            stepN_2 = stepN_1;
            stepN_1 = stepN;
        }
        return stepN;
    }
}
