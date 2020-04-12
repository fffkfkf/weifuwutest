package atguigu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 文件名：JsonUtil.java
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 * 描述：//TODO
 * 作者：zhaowd
 * 时间：2019/9/2 10:37
 **/
public class JsonUtil {
    public static String getValue(String json, String path){
        JSONObject jsonObj = JSONObject.parseObject(json);
        Object o = getValue(jsonObj,path);
        if (null == o) {
            return null;
        } else {
            return o instanceof String ? (String)o : o.toString();
        }
    }

    public static Object getValue(JSONObject jsonObj, String path){
        return getObject(jsonObj.getInnerMap(), path);
    }

    public static <T> T getValue(JSONObject jsonObj, String path, Class<T> clazz){

        Object o = getObject(jsonObj.getInnerMap(), path);
        if (null == o) {
            return null;
        } else {
            return JSON.parseObject(o instanceof String ? (String)o : o.toString(), clazz);
        }
    }


    private static Object getObject(final Map map, final String path) {
        if (null != path && !"".equals(path) && null != map) {
            Map subMap = map;
            String[] keys = path.split("\\.");
            if (keys.length < 2) {
                return map.get(path);
            } else {
                int i;
                for(i = 0; i < keys.length - 1; ++i) {
                    if (null == subMap) {
                        return null;
                    }

                    subMap = (Map)subMap.get(keys[i]);
                }

                if (null == subMap) {
                    return null;
                } else {
                    return subMap.get(keys[i]);
                }
            }
        } else {
            return null;
        }
    }
}
