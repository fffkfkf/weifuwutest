package com.dell.recruit.controller;

import com.dell.recruit.client.LabelClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {

 @Autowired
 private LabelClient labelClient;


 /**
  * 根据ID查询
  *
  * @param id ID
  * @return
  */
 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
 public Result findById(@PathVariable String id) {// http://localhost:9002/recruit/2
  System.out.println(id);
  return new Result(true, StatusCode.OK, "查询成功", "成功了+id+RecruitController");

 }

 /**
  * 实现feign的调用, reruit 模块调用base模块的findAll方法.
  * @param
  * @return
   */
 @RequestMapping(value = "/label",method = RequestMethod.POST)
 public Result findAll() {// http://localhost:9002/recruit/label
  //System.out.println(labelId);
  Result r = labelClient.findAll();
  System.out.println("findAll方法执行了");
  return r;
 }
}
