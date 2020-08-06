package suanfa.动态规划;

/**
 * 剪绳子问题:
 *
 * @author gmq
 * @date 2020/6/1
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class CutRope {

    public static int cutRope(int target) {

        if (target<2){
            return 0;
        }
        if (target==2){
            return 1;
        }

        if (target==3){
            return 2;
        }

        int max = 0;
        int[] product = new int[target+1];
        product[0]=0;
        product[1]=1;
        product[2]=2;
        product[3]=3;

        for (int i = 4; i <= target; ++  i) {
            max=0;
            for (int j = 1; j <= i / 2; ++j) {
                int temp = product[j] * product[i-j];
                if (max < temp) {
                    max = temp;
                }
                product[i] = max;
            }

        }
        max = product[target];
        return max;
    }

    public static void main(String[] args) {

        int www = cutRope(4);
        System.out.println(www);//4

        int aaaa = cutRope(5);
        System.out.println(aaaa);//6

        int i = cutRope(6);
        System.out.println(i);//
        int aaa = cutRope(8);
        System.out.println(aaa);
    }



}
