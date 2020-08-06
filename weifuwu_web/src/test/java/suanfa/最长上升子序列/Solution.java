package suanfa.最长上升子序列;

/**
 * @author gmq
 * @date 2020/5/10
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {
    static int max;

    public static int function(int[] nums, int n) {
        if (n <= 1) {
            return n;
        }
        int result = 0, maxEndingHere = 1;
        for (int i = 1; i < n; i++) {
            result = function(nums, i);
            // 对于i个元素的数组计算后, 看看下个元素是否满足.
            if (nums[i - 1] < nums[n - 1] && result + 1 > maxEndingHere) {
                maxEndingHere = result + 1;
            }
        }
        if (max < maxEndingHere) {
            max = maxEndingHere;
        }
        return maxEndingHere;
    }

    /**
     * 普通递归
     * @param nums
     * @return
     */
    public static int LIS(int[] nums) {
        max = 1;
        function(nums, nums.length);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 2, 9,10,12,15,16,18,19,2,23,2,25,23,24,27,4,67,2,43,2,34,5,455,45,45,4,45,65,65,65,65,664,545,34,53,432,42,4,243,3243,4,3};
        int lis = LIS(nums);
        System.out.println(lis);
    }





}
