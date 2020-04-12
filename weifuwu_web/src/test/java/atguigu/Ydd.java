package atguigu;

/**
 * @author gmq
 * @date 2020/3/30
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
class Parentclass {
static {
    System.out.println(11);
}
    Parentclass(){
        System.out.println(222);
    }

    Parentclass(int a){
        System.out.println(a);
    }

}
class Democ extends Parentclass{
    public Democ(){
        super(33);
        System.out.println(44);
    }

    public static void main(String[] args) {
        new Democ();
    }

}

