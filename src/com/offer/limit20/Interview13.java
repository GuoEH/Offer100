package com.offer.limit20;

import com.offer.datastruct.Matrix;

/**
 * Page92:面试题13：机器人的运动范围
 */
public class Interview13 {
    private int row, col;
    private int threshold;

    public Interview13(int row, int col, int threshold) {
        this.row = row;
        this.col = col;
        this.threshold = threshold;
    }

    public static void main(String[] args) {
        int row = 20, col = 20;
        int threshold = 15;
        Interview13 interview13 = new Interview13(row, col, threshold);
        Matrix matrix = new Matrix<>(row, col);
        int count = interview13.countMovement(matrix);
        System.out.println("[" + row + "*" + col + "]的矩阵在限制为[" + threshold + "]时可移动" + count + "个格子");
    }

    private int countMovement(Matrix matrix) {
        if (matrix == null) {
            return 0;
        }
        Matrix<Boolean> visited = new Matrix<>(matrix.getRows(), matrix.getCols());
        visited.setItemsAll(Boolean.FALSE);
        int count = countMovementCore(matrix, 0, 0, visited);
        return count;
    }

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

    private boolean check(Matrix matrix, int row, int col, Matrix<Boolean> visited) {
        return row >= 0 && row < matrix.getRows() && col >= 0 && col < matrix.getRows()
                && checkMatrixPosition(matrix, row, col) && !visited.valueAt(row, col);
    }

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
