package suanfa.移动0;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 解法:
 * 遍历数组，不为0的元素移动数组前方(0都挤掉)，用index下标记录。
 * 遍历结束，对index值后的元素统一设为0
 *  nums = [0, 1, 0, 3, 12]，调用函数之后， nums 应为 [1, 3, 12, 0, 0]。
 *   nums = [3, 1, 0, 3, 12]，调用函数之后， nums 应为 [1, 3, 12, 0, 0]。
 * @author gmq
 * @date 2020/7/11
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public static void moveZeroes(int[] nums) {
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;// ()、[]、{}优先级最高.所以先赋值,再++.
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums={0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
