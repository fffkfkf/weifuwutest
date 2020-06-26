package atguigu;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author gmq
 * @date 2019/12/31
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class TempTest {

    public static void main(String[] args) {

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        map1.put("1", "b");
        map1.put("77", "b");
        map1.put("2", "d");
        map1.put("3", "r");
        map1.put("ffdfd", "dfsds");
        map1.put("erev", "sdfaa");

        map2.put("77", "b");
        map2.put("1", "b");

        StringBuilder m1 = new StringBuilder();

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String map1Key = entry.getKey();
            String map1Value = entry.getValue();
            String map1KeyVal = map1Key + ":" + map1Value;
            m1.append(map1KeyVal);

        }
        int i = 0;
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String map1Key = entry.getKey();
            String map1Value = entry.getValue();
            String map1KeyVal = map1Key + ":" + map1Value;
            boolean contains = m1.toString().contains(map1KeyVal);
            if (contains) {
                i++;
            }

        }

        if (map2.size() == i) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");

        }

    }

}
