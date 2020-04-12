package atguigu.piaoju;

import java.util.HashMap;

/**
 * 测试Dom4jReadExmple解析的情况
 * @author gmq
 * @date 2020/4/3
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class TestDom4jReadExmple {


    public static void main(String[] args) {
        try{
            //获取解析完后的解析信息
            HashMap<String,String> hashMap;
            Dom4jReadExmple drb=new Dom4jReadExmple();
            //利用XPath操作XML文件，获取想要的属性值
            hashMap = new HashMap<String,String>();
            drb.getSelectedNodeValue("studentInfo.xml", hashMap);
            System.out.println("崔卫兵-age:"+hashMap.get("崔卫兵-age"));
            System.out.println("cwb-age:"+hashMap.get("cwb-age"));
            System.out.println("cwb-college:"+hashMap.get("cwb-college"));
            System.out.println("cwb-college-leader:"+hashMap.get("cwb-college-leader"));
            System.out.println("lxx-college:"+hashMap.get("lxx-college"));
            System.out.println("lxx-college-leader:"+hashMap.get("lxx-college-leader"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
