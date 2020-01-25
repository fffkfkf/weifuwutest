package cn.dell.strategy.log;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class logContext {

    LogStrategy strategy;

    public logContext() {
        strategy=new DbLog();
    }

    public void log(String msg){

         try {
             strategy.log(msg);
         }catch (Exception e){
             strategy= new FileLog();
             strategy.log(msg);
         }


    }
}
