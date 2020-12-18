package atguigu.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author gmq
 * @Description
 * @date 2020/9/23
 */
public class Tyg {

    //用字节流来读,中文出现乱码.
    @Test
    public void main12() throws Exception {
        File file = new File("D:\\xinzhiyun\\base\\Bootstrap (2).yml");
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

    // 读文件, 中文乱码.
    @Test
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

    //1.标准写数据到文件, 写入的字符需要自行转码.
    @Test
    public void main234() throws Exception {
        File file = new File("D:\\xinzhiyun\\base\\333bootstrap.yml");
        // BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new
        // FileOutputStream(file, true), "UTF-8"));
        // FileWriter可以大幅度简化代码
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        // 要写入的字符串
        String string = "松下问童子，言师采药去。只在此山中，云深不知处。";
        bw.newLine();
        bw.write(string);
        bw.close();
    }

    //2.标准写数据到文件, FileOutputStream设置的格式好像没有起作用, 还是看具体的内容是什么格式的.
    @Test
    public void main247() throws Exception {
        File file = new File("D:\\xinzhiyun\\base\\333bootstrap.yml");
        BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8));
        // FileWriter可以大幅度简化代码
        //BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        // 要写入的字符串
        String string = "33333311突突突额额哦哦哦哦哦哦。";
        fw.newLine();
        fw.write(string);
        fw.close();
    }


    //正常的读文件方式, 代码混乱.
    @Test
    public void main16() {
        File file = new File("D:\\xinzhiyun\\base\\333bootstrap.yml");
        if (!file.exists()) {
            try {
                boolean newFile = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FileInputStream fi = null;
            InputStreamReader input = null;
            BufferedReader bufferedReader = null;
            try {
                fi = new FileInputStream(file);
                //原始文件utf-8, 用gbk读, 乱码
                //InputStreamReader input = new InputStreamReader(fi, "gbk");
                input = new InputStreamReader(fi, StandardCharsets.UTF_8);
                bufferedReader = new BufferedReader(input);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("异常111------");
            } finally {
                try {
                    fi.close();
                    input.close();
                    bufferedReader.close();
                    System.out.println("关完了------");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("异常222------");
                }
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

    /**
     * 读文件的各种方法.
     * @throws Exception
     */
    @Test
    public void main19() throws Exception {
        //FileInputStream ww = new FileInputStream("D:\\xinzhiyun\\base\\bootstrap.yml");
        Path path = Paths.get("D:\\xinzhiyun\\batch\\20200921\\OFD_GY_100004_20200921_LTX2.TXT");

        //------------------------------------
        //第一种方法:
        InputStream inputStream = Files.newInputStream(path);
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        inputStream.close();
        in.close();

        System.out.println("------1---------");
        //第二种方法:
        List<String> ad = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String ss : ad) {
            System.out.println(ss);
        }

        // 第3种方法:以下是流:
        System.out.println("------以下是流---------");
        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        lines.forEach((v) -> {
            System.out.println(v.length());
            System.out.println(v);
        });
    }

    /**
     * 正则表达式
     *
     * @throws Exception
     */
    @Test
    public void main20() throws Exception {
        String regex = "[cba].+大就";
        String ss = "ajkli大";

        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(ss);
        if (matcher.matches()) {
            System.out.println("-----匹配了!");
        } else {
            System.out.println("----不匹配");
        }


    }

}
