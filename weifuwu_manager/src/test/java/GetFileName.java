import org.junit.Test;

import java.io.File;

/**
 * @author gmq
 * @date 2019/12/18
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class GetFileName {

    /**
     *   获取所有的文件名
     */
    @Test
    public void test1() {
        //路径   这里写一个路径进去
        String path = "D:\\11siteqiwork\\sitechSvn2\\03概要设计\\32概要设计说明书\\建表脚本\\mysql\\单据\\实例表\\正表";

        //调用方法      D:\11siteqiwork\jcf315cailiao\新建文件夹\33其它\331过程文档

        getFiles(path);
    }

    static String newString = "";//新字符串,如果是去掉前缀后缀就留空，否则写上需要替换的字符串
    static String oldString = "home.cnblogs.comu";//要被替换的字符串
    static String dir = "D:\\linshi";//文件所在路径，所有文件的根目录，记得修改为你电脑上的文件所在路径

    /**
     *  修改文件名字
     */
    @Test
    public void test2() {
        recursiveTraversalFolder(dir);//递归遍历此路径下所有文件夹
    }

    /**
     * 递归遍历文件夹获取文件
     */
    public static void recursiveTraversalFolder(String path) {
        File folder = new File(path);
        if (folder.exists()) {
            File[] fileArr = folder.listFiles();
            if (null == fileArr || fileArr.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                File newDir = null; //文件所在文件夹路径+新文件名
                String newName = ""; //新文件名
                String fileName = null; //旧文件名
                File parentPath = new File("");//文件所在父级路径
                for (File file : fileArr) {
                    if (file.isDirectory()) { //是文件夹，继续递归，如果需要重命名文件夹，这里可以做处理
                        System.out.println("文件夹:" + file.getAbsolutePath() + "，继续递归！");
                        recursiveTraversalFolder(file.getAbsolutePath());
                    } else { //是文件，判断是否需要重命名
                        fileName = file.getName();
                        parentPath = file.getParentFile();

                        if (fileName.contains(oldString)) { //文件名包含需要被替换的字符串
                            newName = fileName.replaceAll(oldString, newString);//新名字
                            newDir = new File(parentPath + "/" + newName);//文件所在文件夹路径+新文件名
                            file.renameTo(newDir);//重命名
                            System.out.println("修改后：" + newDir);
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }


    /**
     * 递归获取某路径下的所有文件，文件夹，并输出
     */
    public static void getFiles(String path) {
        File file = new File(path);
        // 如果这个路径是文件夹
        if (file.isDirectory()) {
            // 获取路径下的所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (files[i].isDirectory()) {
                    //System.out.println("目录：" + files[i].getPath());
                    //getFiles(files[i].getPath());
                } else {
                    System.out.println(files[i].getName());
                }

            }
        } else {
            System.out.println("文件：" + file.getPath());
        }
    }

}
