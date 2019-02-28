package com.dell.recruit.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {
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


}
