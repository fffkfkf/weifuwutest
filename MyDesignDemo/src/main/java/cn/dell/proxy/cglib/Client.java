package cn.dell.proxy.cglib;

/**
 * @author gmq
 * @date 2020/1/25
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Client {

    public static void main(String[] args) {
        TeacherDAO teacherDAO = new TeacherDAO();
        TeacherDAO proxyInstance = (TeacherDAO) new ProxyFactory(teacherDAO).getProxyInstance();

        String xiaoming = proxyInstance.teach("xiaoming");
        System.out.println(xiaoming);

    }






}
