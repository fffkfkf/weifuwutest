package cn.dell.strategy.log;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class FileLog implements LogStrategy {

    @Override
    public void log(String msg) {
        System.out.println("现在把 '"+msg+"' 记录到文件中");
    }
}
