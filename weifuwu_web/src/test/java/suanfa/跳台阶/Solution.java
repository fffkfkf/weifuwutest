package suanfa.跳台阶;

/**
 * 普通跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *斐波那契数列递归求解的算法时间复杂度是O(2^n)，即2的n次方.
 * @author gmq
 * @date 2020/7/11
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public int JumpFloor(int target) {
        if(target<=1){
            return 1;
        }

        return JumpFloor(target-1)+JumpFloor(target-2);

    }

    public static void main(String[] args) {



    }



}
