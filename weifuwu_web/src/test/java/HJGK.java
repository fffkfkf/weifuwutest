
import org.junit.Test;

import java.io.*;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.util.*;

/**
 * @author gmq
 * @date 2020/7/25
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class HJGK {

    @Test
    public  void main23332()  {
        try {
            sss();
        }catch (Exception e){
            System.out.println("--111");
        }
        System.out.println("--222222");
    }

    private void sss() {
        try{
            int a=1/0;
        }catch (Exception e){
            System.out.println("---333333--");
        }
        System.out.println("--444444");
    }


    public static String completeStr(String srcStr, int length) {
        if (srcStr == null) {
            srcStr = "";
        }

        int srcLength = srcStr.getBytes(Charset.forName("GB18030")).length;
        if (srcLength <= length) {
            StringBuilder sb = new StringBuilder(srcStr);
            for (int i = 0; i < length - srcLength; i++) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            throw new RuntimeException("字符串长度过长:" + srcStr);
        }
    }


    public static LocalDateTime getLastWorkDate(LocalDateTime dateTime) {
        LocalDateTime lastWorkDate = dateTime.minusDays(1);

        while (checkWeekend(lastWorkDate) || checkHoliday(dateTime)) {
            lastWorkDate = lastWorkDate.minusDays(1);
        }
        return lastWorkDate;
    }

    /** 校验周末 **/
    public static boolean checkWeekend(LocalDateTime dateTime) {
        DayOfWeek week = dateTime.getDayOfWeek();
        if(week.compareTo(DayOfWeek.SATURDAY) == 0 || week.compareTo(DayOfWeek.SUNDAY) == 0) {
            return true;
        }
        return false;
    }

    /** 校验节假日 **/
    public static boolean checkHoliday(LocalDateTime dateTime) {
        // FIXME
        return false;
    }




    //实现 java.lang.AutoCloseable
    private static void customBufferStreamCopy(File source, File target) {
        try (InputStream fis = new FileInputStream(source);
             OutputStream fos = new FileOutputStream(target)){

            byte[] buf = new byte[8192];

            int i;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
