package suanfa.移动0;

import java.util.Arrays;

/**
 * 把0移动到最前边.
 * @author gmq
 * @date 2020/7/31
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution2 {

    public static void moveZeroes(int[] nums) {
        int index = nums.length-1;
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i] != 0) {
                nums[index--] = nums[i];// ()、[]、{}优先级最高.所以先赋值,再++.
            }
        }
        while (index >=0) {
            nums[index--] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums={0, 1, 0, 3, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
