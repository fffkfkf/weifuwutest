package com.dell.manager.service;

import com.dell.manager.service.inter.QueryCrud;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gmq
 * @date 2019/12/22
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
@Service
public class QueryCrudImpl implements QueryCrud {

    @Override
    public int getFsmNumById()  {
        ArrayList<String> list = new ArrayList<>();
        try{
            list.get(3);
        }
        catch (ArrayIndexOutOfBoundsException e){
            //记录日志
            System.out.println("记录日志");
            //给用户看的
            throw new ArrayIndexOutOfBoundsException("手机号不能为空！");
        }

        int u=1/0;
        return 0;
    }

    //@Override
    public int getFsmNumByTime() {
        Map<Object, Object> objectObjectHashMap = new HashMap<>();
        return 0;
    }
}
