package cn.dell.strategy.log;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public interface LogStrategy {

    /**

     * 记录日志

     * @param msg 需记录的日志信息

     */

    public void log(String msg);
}
