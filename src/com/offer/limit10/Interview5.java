package com.offer.limit10;

/**
 * Page51：面试题5：替换空格
 */
public class Interview5 {
    public static void main(String[] args) {
        Interview5 interview5 = new Interview5();
        String str = "we are the champion, my friend";
        String str1 = " we are the champion, my friend";
        String str2 = " we are the champion, my friend ";
        String str3 = null;
        String test = str;
        System.out.println("原字符串是：" + test);
        String replacedStr = interview5.replaceSpace(test);
        System.out.println("替换后的字符串是：" + replacedStr);

        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        interview5.print(array1);
        int[] array2 = {1, 2, 4, 5, 8, 9};
        interview5.print(array2);
        int[] newArray = interview5.contact(array1, array2);
        interview5.print(newArray);
    }

    /**
     * @param str
     * @return
     */
    public String replaceSpace(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        int originLength = str.length();
        int blankNumber = 0;
        for (int i = 0; i < originLength; ) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                blankNumber++;
            }
            i++;
        }
        if (blankNumber == 0) {
            return str;
        }
        int newLength = blankNumber * 2 + originLength;
        int indexOfOrigin = originLength - 1;
        int indexOfNew = newLength - 1;
        char[] chars = new char[newLength];
        while (indexOfOrigin >= 0 && indexOfNew >= indexOfOrigin) {
            char ch = str.charAt(indexOfOrigin);
            if (ch == ' ') {
                chars[indexOfNew--] = '0';
                chars[indexOfNew--] = '2';
                chars[indexOfNew--] = '%';
            } else {
                chars[indexOfNew--] = ch;
            }
            indexOfOrigin--;
        }
        return new String(chars);
    }

    /**
     * 相关题目：两个有序数组合并成新的有序数组
     *
     * @param array1 第一个有序数组
     * @param array2 第二个有序数组
     * @return 新的有序数组
     */
    public int[] contact(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }
        if (array1 == null) {
            return array2;
        }
        if (array2 == null) {
            return array1;
        }
        int indexOfArray1 = array1.length - 1;
        int indexOfArray2 = array2.length - 1;
        int totalLength = indexOfArray1 + indexOfArray2 + 2;
        int indexOfNew = totalLength - 1;

        int[] newArray = new int[totalLength];
        while (indexOfArray1 >= 0 || indexOfArray2 >= 0) {
            if (indexOfArray1 < 0) {
                newArray[indexOfNew--] = array2[indexOfArray2--];
            } else if (indexOfArray2 < 0 || array1[indexOfArray1] >= array2[indexOfArray2]) {
                newArray[indexOfNew--] = array1[indexOfArray1--];
            } else {
                newArray[indexOfNew--] = array2[indexOfArray2--];
            }
        }
        return newArray;
    }

    private void print(int[] array) {
        if (array == null || array.length == 0){
            System.out.println("数组为空");
            return;
        }
        System.out.println("数组内容为:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
