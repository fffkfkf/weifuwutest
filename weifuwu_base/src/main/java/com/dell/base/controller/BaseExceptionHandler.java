package com.dell.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基础微服务异常处理类
 */
@ControllerAdvice       // 对Controller方法进行处理类
public class BaseExceptionHandler {

    /**
     * 异常处理方法
     * controller抛出任何异常，该方法都会执行
     * @return
     */
    @ExceptionHandler(value = Exception.class)   // 异常处理的方法
    @ResponseBody   // 把result对象转换成json，响应
    public Result execute(Exception e){
        // 在控制台打印
        e.printStackTrace();
        // 写入到文件中
        // 给用户提示
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }

}












