import java.io.File;

/**
 * @author gmq
 * @date 2019/12/18
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class GetFileName {

    public static void main(String[] args) {
        //路径   这里写一个路径进去
        String path="D:\\11siteqiwork\\jcf315cailiao\\新建文件夹\\33其它\\331过程文档";
        //调用方法
        getFiles(path);

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
                    System.out.println( files[i].getName());
                }

            }
        } else {
            System.out.println("文件：" + file.getPath());
        }
    }

}
