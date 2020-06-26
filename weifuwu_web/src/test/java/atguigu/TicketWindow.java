package atguigu;

/**
 * @author gmq
 * @date 2020/5/11
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class TicketWindow extends Thread {
    private final String name;
    private static final int MAX = 1000;
    private static int index = 1;
    public TicketWindow(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + "当前的号码是:" + (index++));
        }
        System.out.println("----"+index);
    }
}
