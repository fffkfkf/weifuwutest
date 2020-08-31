package qitashiyan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * 滴滴面试:
 * 对一个json, 把所有的key转为小写(或者去掉_),
 * @author gmq
 * @date 2020/8/26
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class JsonTest {

    @Test
    public void test1() {
        String ss = "{\n" +
                "\t\"ROOT\": {\n" +
                "\t\t\"HEADER\": {\n" +
                "\t\t\t\"POOL_ID\": \"31\",\n" +
                "\t\t\t\"DB_ID\": \"\",\n" +
                "\t\t\t\"CHANNEL_ID\": \"02\",\n" +
                "\t\t\t\"ROUTING\": {\n" +
                "\t\t\t\t\"ROUTE_KEY\": \"10\",\n" +
                "\t\t\t\t\"ROUTE_VALUE\": \"13988880001\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"TRACE_ID\": \"11*20170525094012105*0008**772266\",\n" +
                "\t\t\t\"PHONE_NO\": \"13988880001\",\n" +
                "\t\t\t\"KEEP_LIVE\": \"\",\n" +
                "\t\t\t\"SUB_TRACE_ID\": \"\",\n" +
                "\t\t\t\"PASSWORD\": \"\",\n" +
                "\t\t\t\"ENDUSRIP\": \"\",\n" +
                "\t\t\t\"USERNAME\": \"aaaaxp\",\n" +
                "\t\t\t\"CONTACT_ID\": \"\",\n" +
                "\t\t\t\"ENV_ID\": \"\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        JSONObject parse = (JSONObject) JSON.parse(ss);
        JSONObject convert = convert(parse);
        System.out.println(convert);
    }

    public JSONObject convert(JSONObject json) {

        Iterator<Map.Entry<String, Object>> iterator = json.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object obj = next.getValue();
            System.out.println("nextkey----"+key);
            String result = dealStr(key);
            JSONObject jsonObject = new JSONObject();;
            JSONArray jsonArray= new JSONArray();
            if(obj instanceof JSONObject){
                jsonObject = json.getJSONObject(key);
                json.put(result, convert(jsonObject));
                json.remove(key);

            }else if(obj instanceof JSONArray){
                jsonArray = json.getJSONArray(key);
                //处理array, 先不处理集合里边的.
                //Iterator<Object> iterator1 = jsonArray.iterator();
                json.put(result,jsonArray);
                json.remove(key);
            }else {
                //string
                System.out.println("string----"+obj.toString());
            }
        }

        return json;
    }

    public JSONArray convertArr(JSONArray json) {

        return null;
    }

    private String dealStr(String str) {
        if (str.matches("[a-zA-Z]+_[a-zA-Z]+")) {
            String[] s = str.split("_");

            return s[0] + s[1];
        }
        return str;
    }

    @Test
    public void test33() {
        String aa_dd = dealStr("aa_dd");
        System.out.println(aa_dd);
    }

}
