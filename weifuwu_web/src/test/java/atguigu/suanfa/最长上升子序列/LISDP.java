package atguigu.suanfa.最长上升子序列;

/**
 * @author gmq
 * @date 2020/5/10
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class LISDP {

    public static int LIS(int[] nums, int n) {
        int[] cache = new int[n];
        int i, j, max = 0;
        for (i = 0; i < n; i++) {
            cache[i] = 1;
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (nums[j] < nums[i] && cache[i] < cache[j] + 1) {
                    cache[i] = cache[j] + 1;
                }
            }
            max = Math.max(max, cache[i]);
        }
        return max;
    }

    /**
     *  自底向上, 时间复杂度为n的平方,
     * @param nums
     * @return
     */
    public static int LIS(int[] nums) {

        int max= LIS(nums, nums.length);
        return max;
    }


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int[] nums = {2, 1, 5, 2, 9, 10, 12, 15, 16, 18, 19, 2, 23, 2, 25, 23, 24, 27, 4, 67, 2, 43, 2, 34, 5, 455, 45, 45, 4, 45, 65,
                65, 65, 65, 664, 545, 34, 53, 432, 42, 4, 243, 3243, 4, 3, 1, 5, 2, 9, 10, 12, 15, 16, 18, 19, 2, 23, 2, 25, 23, 24,
                27, 4, 67, 2, 43, 2, 34, 5, 455, 45, 45, 4, 45, 65, 65, 65, 65, 664, 545, 34, 53, 432, 42, 4, 243, 3243, 4, 3};
        int lis = LIS(nums);
        System.out.println(lis);
        long end = System.currentTimeMillis();
        System.out.println(end-l);
    }


}
