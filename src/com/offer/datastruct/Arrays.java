package com.offer.datastruct;

import java.util.Random;

public class Arrays {
    public static int[] createData(int length,int range){
        int[] array = new int[length];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }

    public static void print(int[] array){
        System.out.println("array>>>");
        if (array == null){
            System.out.println("null");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("<<<");
    }
}
