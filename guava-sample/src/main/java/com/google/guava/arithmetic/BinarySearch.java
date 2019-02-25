package com.google.guava.arithmetic;

/**
 *  jdk中原生的Arrays.binarySearch重载方法，及Collections.binarySearch都有例子。
 *  二分查找必须得先保证数组是排序后的，才能使用二分查找
 */
public class BinarySearch {

    public static void main(String args[]) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(a, 0, 10, 11));
    }

    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;   //防止出现很大的数字，可用(low + high) / 2
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
