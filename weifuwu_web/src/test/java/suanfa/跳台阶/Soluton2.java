package suanfa.跳台阶;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author gmq
 * @date 2020/7/21
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Soluton2 {

    public int JumpFloorII(int target) {

        if (target < 2) {
            return 1;
        }
        //用两个数列相减
        return 2 * JumpFloorII(target - 1);

    }



}
