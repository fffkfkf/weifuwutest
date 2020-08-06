package paixu;

/**
 * 快排
 *
 * @author gmq
 * @date 2020/7/23
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Kuaipai {

    public static int partition(int[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) { //从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) { //从前半部分向后扫描
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }


}
