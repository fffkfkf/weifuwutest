package com.dell.base.controller;
import com.dell.base.Service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/label")
@CrossOrigin
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询所有 http://localhost:9001/label
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        // 调用service，查询
        String a=labelService.findAll();
        System.out.println(a);
        // 返回结果
        return new Result(true, StatusCode.OK,"LabelController查询成功");
    }



}
