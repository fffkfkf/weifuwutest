package atguigu.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

/**
 * @author gmq
 * @Description
 * @date 2020/9/23
 */
public class Tyg {

    @Test
    public void main11() {
        File file = new File("D:\\xinzhiyun\\base\\333bootstrap.yml");
        String name = file.getName();
        System.out.println(name);
        try {
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file2 = new File("D:\\Xinzhiyun\\base\\333bootstrap.yml");
        System.out.println(file2.getName());
        int i = file.compareTo(file2);
        System.out.println(i);
        Path path = file2.toPath();
        System.out.println(path);

    }

    @Test
    public void main12() throws Exception {
        File file = new File("D:\\xinzhiyun\\base\\bootstrap.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已经存在-----");
            FileInputStream fileInputStream = new FileInputStream(file);
            int read = fileInputStream.read();
            while (read > 0) {
                System.out.println(read + "--" + (char) read);
                read = fileInputStream.read();
            }

        }

    }

    @Test//todo  ?????????????
    public void main13() throws Exception {
        File file = new File("D:\\xinzhiyun\\base\\333bootstrap.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            byte[] bytes = new byte[10];//1kb
            FileInputStream fileInputStream = new FileInputStream(file);
            int read = fileInputStream.read(bytes);
            while (read > 0) {
                read = fileInputStream.read(bytes);
                String s = new String(bytes);
                System.out.print(s);
                // System.out.println(read);
            }

        }

    }

    @Test//写入
    public void main14() throws Exception {
        byte[] bytes = new byte[1024];
        byte a = 23;
        bytes[2] = a;
        FileOutputStream fileInputStream = new FileOutputStream("D:\\xinzhiyun\\base\\333bootstrap.yml", true);
        fileInputStream.write(bytes);
    }

    @Test//
    public void main15() throws Exception {
        File file = new File("D:\\xinzhiyun\\base\\333bootstrap.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            FileInputStream fileInputStream = new FileInputStream(file);
            //获取字符输入流
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            char[] c = new char[100];

            //int read = inputStreamReader.read(c);

            // System.out.println( new String(c));
            System.out.println("-----------");

            FileReader fileReader = new FileReader(file);
            int read1 = fileReader.read(c);
            System.out.println(new String(c));
            System.out.println("----3333333333-------");

        }
    }

    @Test //
    public void main16() throws Exception {
        File file = new File("D:\\xinzhiyun\\base\\333bootstrap.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FileInputStream fi = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fi, "gbk");
            BufferedReader bufferedReader = new BufferedReader(input);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }


    @Test // 写, 没有关闭流.文件没有写入.
    public void main17() throws Exception {
        File file = new File("D:\\xinzhiyun\\base\\bootstrap.yml");
        File file1 = new File("D:\\xinzhiyun\\base\\333bootstrap.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已存在");
            try {
//                使用InputStreamReader
                FileInputStream fileInputStream = new FileInputStream(file);
                //获取字符输入流
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                FileOutputStream fileOutputStream = new FileOutputStream(file1);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    @Test // 写, 自动关闭
    public void main18() throws Exception {
        File file = new File("D:\\xinzhiyun\\base\\bootstrap.yml");
        File file1 = new File("D:\\xinzhiyun\\base\\333bootstrap.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已存在");
            try (
                    // 使用InputStreamReader
                    FileInputStream fileInputStream = new FileInputStream(file);
                    //获取字符输入流
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    //------
                    FileOutputStream fileOutputStream = new FileOutputStream(file1);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            ) {
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


}
