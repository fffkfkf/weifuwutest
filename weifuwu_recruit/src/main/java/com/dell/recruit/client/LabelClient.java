package com.dell.recruit.client;

import com.dell.recruit.client.imple.LabelClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "weifuwu-base",fallback = LabelClientImpl.class)
public interface LabelClient {

@RequestMapping(value = "/label",method = RequestMethod.GET)
 public Result findAll();


}
