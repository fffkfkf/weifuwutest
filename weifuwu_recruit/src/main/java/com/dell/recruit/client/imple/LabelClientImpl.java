package com.dell.recruit.client.imple;

import com.dell.recruit.client.LabelClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

@Component
public class LabelClientImpl implements LabelClient {

 @Override
 public Result findAll() {
  return new Result(false, StatusCode.ERROR,"熔断器启动了");
 }
}
