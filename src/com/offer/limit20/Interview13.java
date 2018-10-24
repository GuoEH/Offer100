package com.offer.limit20;

import com.offer.datastruct.Matrix;

/**
 * Page92:面试题13：机器人的运动范围
 */
public class Interview13 {
    /**
     * 限制值
     */
    private int threshold;

    public Interview13(int threshold) {
        this.threshold = threshold;
    }

    public static void main(String[] args) {
        int threshold = 15;
        Interview13 interview13 = new Interview13(threshold);
        int row = 20, col = 20;
        Matrix matrix = new Matrix<>(row, col);
        int count = interview13.countMovement(matrix);
        System.out.println("[" + row + "*" + col + "]的矩阵在限制为[" + threshold + "]时可移动" + count + "个格子");
    }

    /**
     * 计算矩阵内符合条件的格子数
     * @param matrix 要计算的矩阵
     * @return 符合条件的格子数
     */
    public int countMovement(Matrix matrix) {
        if (matrix == null) {
            return 0;
        }
        Matrix<Boolean> visited = new Matrix<>(matrix.getRows(), matrix.getCols());
        visited.setItemsAll(Boolean.FALSE);
        return countMovementCore(matrix, 0, 0, visited);
    }

    /**
     * 算法核心
     * @param matrix 矩阵
     * @param row 当前行
     * @param col 当前列
     * @param visited 记录格子是否统计过的矩阵
     * @return 符合条件的格子数
     */
    private int countMovementCore(Matrix matrix, int row, int col, Matrix<Boolean> visited) {
        int count = 0;
        if (check(matrix, row, col, visited)) {
            visited.setItem(row, col, Boolean.TRUE);
            count = 1 + countMovementCore(matrix, row - 1, col, visited)
                    + countMovementCore(matrix, row, col - 1, visited)
                    + countMovementCore(matrix, row, col + 1, visited)
                    + countMovementCore(matrix, row + 1, col, visited);
        }
        return count;
    }

    /**
     * 检查当前位置是否符合条件
     * @param matrix 矩阵
     * @param row 当前行
     * @param col 当前列
     * @param visited 记录格子是否统计过的矩阵
     * @return 是否符合条件
     */
    private boolean check(Matrix matrix, int row, int col, Matrix<Boolean> visited) {
        return row >= 0 && row < matrix.getRows() && col >= 0 && col < matrix.getRows()
                && checkMatrixPosition(matrix, row, col) && !visited.valueAt(row, col);
    }

    /**
     * 计算矩阵当前位置行与列各位数的积是否小于threshold
     * @param matrix 矩阵
     * @param row 当前行
     * @param col 当前列
     * @return 是否小于threshold
     */
    private boolean checkMatrixPosition(Matrix matrix, int row, int col) {
        int value = 0;
        while (row != 0) {
            value += row % 10;
            row /= 10;
        }
        while (col != 0) {
            value += col % 10;
            col /= 10;
        }
        return value <= threshold;
    }
}
