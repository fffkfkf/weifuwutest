import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 请用java或c/c++语言编程判断一个包含{}()[]的表达式括号是否合法，合法返回true，不合法返回false。
 * 合法标准：
 * （1）左括号必须要有相同类型的右括号闭合，如‘(’必须要有‘)’闭合；
 * （2）左括号必须以正确的顺序闭合，如‘([’必须要有‘])’闭合。
 * 输入描述
 * 输入一个包含{}()[]的表达式
 * [(3+4)*5]/2
 *
 * @author gmq
 * @date 2020/7/25
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class HJGK {

    public static JSONObject changeJsonObj(JSONObject jsonObj, Map<String, String> keyMap) {
        JSONObject resJson = new JSONObject();
        Set<String> keySet = jsonObj.keySet();
        for (String key : keySet) {
            String resKey = keyMap.get(key) == null ? key : keyMap.get(key);
            try {
                JSONObject jsonobj1 = jsonObj.getJSONObject(key);
                resJson.put(resKey, changeJsonObj(jsonobj1, keyMap));
            } catch (Exception e) {
                try {
                    JSONArray jsonArr = jsonObj.getJSONArray(key);
                    resJson.put(resKey, changeJsonArr(jsonArr, keyMap));
                } catch (Exception x) {
                    resJson.put(resKey, jsonObj.get(key));
                }
            }
        }
        return resJson;
    }

    public static JSONArray changeJsonArr(JSONArray jsonArr, Map<String, String> keyMap) {
        JSONArray resJson = new JSONArray();
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            resJson.add(changeJsonObj(jsonObj, keyMap));
        }
        return resJson;
    }

    public static void main(String[] args) {
        String jsonStr = "{\"user\":{\"name\":\"张三\",\"sex\":\"男\",\"hobby\":[{\"motion\":\"足球\",\"desc\":\"任性\"},{\"game\":\"英雄联盟\",\"desc\":\"就是这么任性\"}]}}";
        Map<String, String> keyMap = new HashMap<String, String>();
        keyMap.put("name", "XingMing");
        keyMap.put("user", "YongHu");
        keyMap.put("desc", "MiaoShu");
        JSONObject jsonObj = changeJsonObj(JSONObject.parseObject(jsonStr), keyMap);
        System.out.println("换值结果 》》 " + jsonObj.toString());
    }


}
