package com.offer.datastruct;

public class Matrix<T> {
    T[][] matrix;

    public Matrix(int row, int col) {
        matrix = (T[][]) new Object[row][col];
    }

    /**
     * 初始化所有位置都为t
     *
     * @param t 设置的值
     */
    public void setItemsAll(T t) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = t;
            }
        }
    }

    /**
     * 设置row行col列位置的值为t
     *
     * @param row 行
     * @param col 列
     * @param t   设置的值
     */
    public void setItem(int row, int col, T t) {
        matrix[row][col] = t;
    }

    /**
     * 获取列数
     *
     * @return 列数
     */
    public int getCols() {
        return matrix[0].length;
    }

    /**
     * 获取行数
     *
     * @return 行数
     */
    public int getRows() {
        return matrix.length;
    }

    /**
     * 将一个一维数组转换成矩阵
     *
     * @param array 要转换的数组
     */
    public void setMatrix(T[] array) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (array.length != row * col) {
            throw new IllegalArgumentException("数组长度与矩阵大小不同");
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = array[i * col + j];
            }
        }
    }

    public T valueAt(int row, int col) {
        return matrix[row][col];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("matrix = \n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
                sb.append(" ");
            }
            sb.append("\n");

        }
        sb.append("<<<");
        return sb.toString();
    }
}
