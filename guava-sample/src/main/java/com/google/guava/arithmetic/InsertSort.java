package main.java.com.google.guava.arithmetic;

/**
 * Created by dwarf on 17/8/13.
 */
public class InsertSort {

    public static void main(String args[]) {
        Integer[] is = {34, 8, 64, 51, 32, 21};
        InsertSort.insertSort(is);
    }
    /**
     * 插入排序算法：
     * 1、将待插入的元素缓存起来
     * 2、依次比较当前元素和之前的所有元素
     * 3、若发现小与之前元素，则修改当前元素为前一个大值
     * 4、最后当不再小于前一个元素，设置当前值
     * @param a
     */
    public static <AnyType extends Comparable<? super AnyType>> void insertSort(AnyType[] a) {
        int j;

        for(int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            for(j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

}
