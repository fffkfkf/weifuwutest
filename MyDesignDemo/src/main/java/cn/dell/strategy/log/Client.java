package cn.dell.strategy.log;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Client {
    public static void main(String[] args) {
        logContext logContext = new logContext();
        //正常的记录
        logContext.log("记录日志");
        //异常时记录。
        logContext.log("再次的记录日志");
    }

}
