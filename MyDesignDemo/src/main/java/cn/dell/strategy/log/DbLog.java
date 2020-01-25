package cn.dell.strategy.log;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class DbLog implements LogStrategy {

    @Override
    public void log(String msg) {
        //制造错误：模拟数据库链接出现异常
        if (msg != null && msg.trim().length() > 5) {
            int a = 5 / 0;
        }
        System.out.println("现在把 '" + msg + "' 记录到数据库中");

    }
}
