package com.offer;

import java.util.Random;

public class Interview4 {
    public static void main(String[] args) {
        Interview4 interview4 = new Interview4();
        int size = 5;
        int[][] matrix = new int[size][size];
        interview4.createData(matrix, size);
        int number = interview4.getRandomOne(matrix);
        interview4.print(matrix);
        System.out.println("需要查找的数字为："+number);
        boolean found = interview4.findFromRightTop(matrix, number);
        System.out.println("右上查找："+(found ? "该数组中包含:" : "该数组中不包含此数字:") + number);

        boolean found1 = interview4.findFromLeftBottom(matrix, number);
        System.out.println("左下查找："+(found1 ? "该数组中包含:" : "该数组中不包含此数字:") + number);
    }

    public boolean findFromRightTop(int[][] matrix, int number) {
        if (matrix == null) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        if (rows > 0 && cols > 0) {
            int row = 0;
            int col = cols - 1;
            while (row < rows && col >= 0) {
                if (matrix[row][col] == number) {
                    System.out.println("matrix["+row+"]["+col+"] = " +matrix[row][col]+"即为所查找的位置");
                    return true;
                } else if (matrix[row][col] > number) {
                    --col;
                } else {
                    ++row;
                }
            }
        }
        return false;
    }

    public boolean findFromLeftBottom(int[][] matrix,int number){
        if (matrix == null){
            return false;
        }
        int rows = matrix.length,cols = matrix[0].length;
        if (rows >0 && cols>0){
            int row = rows-1;
            int col = 0;
            while (row>=0 && col<cols){
                if (matrix[row][col] == number){
                    System.out.println("matrix["+row+"]["+col+"] = " +matrix[row][col]+"即为所查找的位置");
                    return true;
                }else if (matrix[row][col] < number){
                    ++col;
                }else {
                    --row;
                }
            }
        }
        return false;
    }

    public void createData(int[][] matrix, int size) {
        final int max = 10;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0) {
                    if (j == 0) {
                        matrix[i][j] = random.nextInt(max);
                    } else {
                        matrix[i][j] = random.nextInt(max) + matrix[i][j - 1] + 1;
                    }
                } else {
                    if (j == 0) {
                        matrix[i][j] = random.nextInt(max) + matrix[i - 1][j] + 1;
                    } else {
                        matrix[i][j] = random.nextInt(max) + Math.max(matrix[i - 1][j], matrix[i][j - 1]) + 1;
                    }
                }
            }
        }
    }

    private int getRandomOne(int[][] matrix) {
        Random random = new Random(System.currentTimeMillis());
        int i = random.nextInt(matrix.length);
        int j = random.nextInt(matrix[i].length);
        return matrix[i][j]+1;
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
