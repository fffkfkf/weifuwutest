package suanfa.和为S的连个数字;

import java.util.ArrayList;

/**
 * @author gmq
 * @date 2020/4/12
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public static void main(String[] args) {
        int[] array= {1,2,4,7,11,15};

        ArrayList<Integer> integers = FindNumbersWithSum(array, 15);
        System.out.println(integers);


    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array==null){
            return result;
        }
        if (array.length==1){
            result.add(array[0]);
            return result;
        }
        for (int i=0; i<=array.length-2;i++){
            for (int j=1; j<=array.length-1;j++) {
                if ((array[i] + array[j]) == sum) {
                    result.add(array[i]);
                    result.add(array[j]);
                    return result;
                }
            }
        }
        return result;
    }
}
