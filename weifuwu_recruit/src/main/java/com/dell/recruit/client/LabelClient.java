package com.dell.recruit.client;

import com.dell.recruit.client.imple.LabelClientImpl;
import entity.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//fallback 是指recruit模块调用base模块时,定义容错的处理类，当调用远程接口失败或超时时，会调用对应接口的容错逻辑.
@FeignClient(value = "weifuwu-base",fallback = LabelClientImpl.class)
public interface LabelClient {

@RequestMapping(value = "/label",method = RequestMethod.GET)
 public Result findAll();


}
