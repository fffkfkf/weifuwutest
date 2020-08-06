package paixu;

/**
 * 大到小, 冒泡排序
 * @author gmq
 * @date 2020/7/23
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Maopaopaixu {


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 6, 4};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                int temp;
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
