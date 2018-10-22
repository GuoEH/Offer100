package com.offer.limit20;

import com.offer.datastruct.Matrix;

/**
 * Page89：面试题12:矩阵中的路径
 */
public class Interview12<T> {
    public static void main(String[] args) {
        Interview12 interview12 = new Interview12();
        int row = 3, col = 4;
        Matrix<Character> characterMatrix = new Matrix<>(row, col);
        Character[] characterArray = {'a', 'b', 'c', 'd'
                , 'e', 'f', 'g', 'h'
                , 'i', 'j', 'k', 'l'};
        characterMatrix.setMatrix(characterArray);
        String str = "abfgkl";
        System.out.println(characterMatrix);
        boolean contains = interview12.isMatrixContainPath(characterMatrix, str);
        System.out.println(contains ? "包含" : "不包含");
    }

    /**
     * 记录字符串当前下表
     */
    private int current = 0;

    /**
     * 矩阵中是否包含字符串路径
     * @param matrix 字符矩阵
     * @param str 字符串
     * @return 是否包含
     */
    private boolean isMatrixContainPath(Matrix<Character> matrix, String str) {
        if (matrix == null) {
            return false;
        }
        if (str == null || str.length() == 0) {
            return true;
        }
        Matrix<Boolean> visited = new Matrix<>(matrix.getRows(), matrix.getCols());
        visited.setItemsAll(Boolean.FALSE);
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                if (isMatrixContainPathCore(matrix, i, j, str.toCharArray(), visited)) {
                    return true;
                }
            }
        }
        current = 0;
        return false;
    }

    /**
     * 核心算法
     * @param matrix 字符矩阵
     * @param row 当前行
     * @param col 当前列
     * @param array 目标字符串
     * @param visited 记录字符矩阵是否被访问过的矩阵
     * @return 是否包含
     */
    private boolean isMatrixContainPathCore(Matrix<Character> matrix, int row, int col, char[] array, Matrix<Boolean> visited) {
        System.out.println("row = [" + row + "], col = [" + col + "]");
        if (current == array.length) {
            return true;
        }
        boolean has = false;
        if (row >= 0 && row < matrix.getRows() && col >= 0 && col < matrix.getCols()
                && matrix.valueAt(row, col) == array[current] && !visited.valueAt(row, col)) {
            current++;
            visited.setItem(row, col, Boolean.TRUE);

            has = isMatrixContainPathCore(matrix, row, col - 1, array, visited)
                    || isMatrixContainPathCore(matrix, row - 1, col, array, visited)
                    || isMatrixContainPathCore(matrix, row, col + 1, array, visited)
                    || isMatrixContainPathCore(matrix, row + 1, col, array, visited);
            if (!has) {
                current--;
                visited.setItem(row, col, Boolean.FALSE);
                System.out.println("rollback");
            }
        } else {
            System.out.println("invalid");
        }
        return has;
    }
}