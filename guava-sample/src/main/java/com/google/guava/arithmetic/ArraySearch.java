package com.google.guava.arithmetic;

/**
 * Created by wangzx on 2017/7/18.
 */
public class ArraySearch {
    public static void main(String args[]) {
        long t1 = System.currentTimeMillis();
        int[][] arr={{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        System.out.println(search(arr, 7));

        System.out.println(System.currentTimeMillis() - t1);
    }

    private static boolean search(int[][] array, int key) {
        int row = array.length;
        int col = array[0].length;

        int i = 0;
        int j = col - 1;
        while(i < row && j >= 0) {
            if(array[i][j] == key) {
                return true;
            }

            if(array[i][j] > key) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
