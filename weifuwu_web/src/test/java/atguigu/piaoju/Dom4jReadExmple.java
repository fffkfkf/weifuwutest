package atguigu.piaoju;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 利用dom4j与XPath进行XML解析
 * @author gmq
 * @date 2020/4/3
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */

public class Dom4jReadExmple {

    /**
     * 利用XPath操作XML文件，获取指定节点或者属性的值，并放入HashMap中
     * @param filename String 待操作的XML文件（相对路径或者绝对路径）
     * @param hm       HashMap 存放选择的结果，格式：<nodename,nodevalue>或者<nodename+attrname,attrvalue>
     */
    public void getSelectedNodeValue(String filename, HashMap< String, String > hm) {
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new File(filename));
            //获取学生姓名为"崔卫兵"的年龄
            List list = document.selectNodes("/students/student[name=\"崔卫兵\"]/@age");
            Iterator iter = list.iterator();
            if (iter.hasNext()) {
                Attribute attribute = (Attribute) iter.next();
                hm.put("崔卫兵-" + attribute.getName(), attribute.getValue());
            } else {
                hm.put("崔卫兵-age", "20");
            }

            //获取学生姓名为"崔卫兵"的年龄
            list = document.selectNodes("/students/student[name=\"cwb\"]/@age");
            iter = list.iterator();
            if (iter.hasNext()) {
                Attribute attribute = (Attribute) iter.next();
                hm.put("cwb-" + attribute.getName(), attribute.getValue());
            } else {
                hm.put("cwb-age", "20");
            }

            //获取学生姓名为"cwb"所在的学院名称
            list = document.selectNodes("/students/student[name=\"cwb\"]/college");
            iter = list.iterator();
            if (iter.hasNext()) {
                Element element = (Element) iter.next();
                String name = element.getName();
                String value = element.getText();
                hm.put("cwb-" + name, value);
            }

            //获取学生姓名为"cwb"所在学院的领导
            list = document.selectNodes("/students/student[name=\"cwb\"]/college/@leader");
            iter = list.iterator();
            if (iter.hasNext()) {
                Attribute attribute = (Attribute) iter.next();
                hm.put("cwb-college-" + attribute.getName(), attribute.getValue());
            } else {
                hm.put("cwb-college-leader", "leader");
            }

            //获取学生姓名为"lxx"所在的学院名称
            list = document.selectNodes("/students/student[name=\"lxx\"]/college");
            iter = list.iterator();
            if (iter.hasNext()) {
                Element element = (Element) iter.next();
                String name = element.getName();
                String value = element.getText();
                hm.put("lxx-" + name, value);
            }

            //获取学生姓名为"lxx"所在学院的领导
            list = document.selectNodes("/students/student[name=\"lxx\"]/college/@leader");
            iter = list.iterator();
            if (iter.hasNext()) {
                Attribute attribute = (Attribute) iter.next();
                hm.put("lxx-college-" + attribute.getName(), attribute.getValue());
            } else {
                hm.put("lxx-college-leader", "leader");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
