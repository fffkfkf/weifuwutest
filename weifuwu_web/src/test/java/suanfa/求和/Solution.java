package suanfa.求和;

/**
 * @author gmq
 * @date 2020/7/11
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public static int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static int Sum(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum(n-1))>0);

        return sum;
    }

    public static void main(String[] args) {

        int sum = Sum(3);
        System.out.println(sum);

        int i = Sum_Solution(3);
        System.out.println(i);



    }

}
