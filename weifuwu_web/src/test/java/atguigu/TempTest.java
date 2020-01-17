package atguigu;

/**
 * @author gmq
 * @date 2019/12/31
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class TempTest {
    private static final long[] bits = {
            0x01,       0x01 << 1,  0x01 << 2,  0x01 << 3,  0x01 << 4,  0x01 << 5,  0x01 << 6,  0x01 << 7,
            0x01 << 8,  0x01 << 9,  0x01 << 10, 0x01 << 11, 0x01 << 12, 0x01 << 13, 0x01 << 14, 0x01 << 15,
            0x01 << 16, 0x01 << 17, 0x01 << 18, 0x01 << 19, 0x01 << 20, 0x01 << 21, 0x01 << 22, 0x01 << 23,
            0x01 << 24, 0x01 << 25, 0x01 << 26, 0x01 << 27, 0x01 << 28, 0x01 << 29, 0x01 << 30, 0x01 << 31,
            0x01 << 32, 0x01 << 33, 0x01 << 34, 0x01 << 35, 0x01 << 36, 0x01 << 37, 0x01 << 38, 0x01 << 39,
            0x01 << 40, 0x01 << 41, 0x01 << 42, 0x01 << 43, 0x01 << 44, 0x01 << 45, 0x01 << 46, 0x01 << 47,
            0x01 << 48, 0x01 << 49, 0x01 << 50, 0x01 << 51, 0x01 << 52, 0x01 << 53, 0x01 << 54, 0x01 << 55,
            0x01 << 56, 0x01 << 57, 0x01 << 58, 0x01 << 59, 0x01 << 60, 0x01 << 61, 0x01 << 62, 0x01 << 63
    };

    public static void main(String[] args) {

        boolean bitOn = isBitOn(0L, 16);
        System.out.println(bitOn);


    }
    //   src=0, bitSeq=16
    public static boolean isBitOn(long src, int bitSeq){
        long bit = bits[bitSeq];
            System.out.println("bit:"+bit);
            String result = Long.toBinaryString(bit);
            System.out.println("result: "+result);
        long value = src & bit;
            System.out.println("value: "+value);

        return bit == value;
    }

}
