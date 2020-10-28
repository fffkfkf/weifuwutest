package atguigu.io;

import org.junit.Test;

import java.io.File;

/**
 * @author gmq
 * @Description
 * @date 2020/9/24
 */
public class IOTest1 {

    /*
     * 1. 在电脑D盘下创建一个文件为HelloWorld.txt文件，
     * 判断他是文件还是目录，再创建一个目录IOTest,
     * 之后将HelloWorld.txt移动到IOTest目录下去；
     * 之后遍历IOTest这个目录下的文件
     */

    @Test
    public void main16() throws Exception {
        File file = new File("D:/HelloWorld.txt");
        file.createNewFile();
        if (file.isFile()){
            System.out.println("是文件");
        }else {
            System.out.println("是目录");
        }
        File file2 = new File("D:/IOTest");
        file2.mkdir();
        File file3 = new File(file2.getPath() + "/" + file.getName());
        boolean b = file.renameTo(file3);
        System.out.println(b);


    }
}
