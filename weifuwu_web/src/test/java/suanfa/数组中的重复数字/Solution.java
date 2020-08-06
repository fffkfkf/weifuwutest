package suanfa.数组中的重复数字;

import java.util.Arrays;

/**
 * // Parameters:
 * //    numbers:     an array of integers
 * //    length:      the length of array numbers
 * //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
 * //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
 * //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
 * // Return value:       true if the input is valid, and there are some duplications in the array number
 * //                     otherwise false
 *
 * @author gmq
 * @date 2020/4/12
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public static void main(String[] args) {
        int[] numbers = {};
        int[] duplication0 = {};
        boolean duplicate2 = duplicate(null, 0, duplication0);
        System.out.println(duplicate2);
    }

    public static boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null) {
            return false;
        }

        Arrays.sort(numbers);
        for (int i = 0; i <= length - 2; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
