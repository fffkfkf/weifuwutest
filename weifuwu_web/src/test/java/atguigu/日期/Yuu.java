package atguigu.日期;

import com.netflix.infix.TimeUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author gmq
 * @Description
 * @date 2020/9/18
 */
public class Yuu {


    @Test
    public  void main23332() {

        LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 0, 1));
        System.out.println(localDateTime1); // 2020-09-18T15:00:01
        Date yesterday = Date.from(getLastWorkDate(localDateTime1).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(yesterday); //Thu Sep 17 15:00:01 CST 2020

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 0, 0));
        Date today = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(today); //Fri Sep 18 15:00:00 CST 2020
    }

    @Test
    public  void main2() throws Exception {
        //获取当前日期
        LocalDate now1 = LocalDate.now();
        System.out.println(now1.toString());
        //获取当前时间
        LocalTime now2 = LocalTime.now();
        System.out.println(now2);
        //获取当前日期时间
        LocalDateTime now3 = LocalDateTime.now();
        System.out.println(now3);
        Date date = new Date();
        System.out.println("date: "+date.toString());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse(simpleDateFormat.format(date));
        System.out.println("转化后的date:"+parse);

        //获取当前日期时间(带时区的)
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime.toString());

        System.out.println("---------------");
        //转换 LocalDateTime---Date
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date2 = Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
        System.out.println(date2);
    }

    // Date类不提倡用getYear()后的补救方法. 例如数据库中是2020-09-01 14:49:52.
    //使用 DateTimeFormatter 替代 SimpleDateFormat(线程不安全)
    @Test
    public  void main3() throws Exception {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       /* Date parse = simpleDateFormat.parse(simpleDateFormat.format(date));
        System.out.println(parse);*/
        String format = simpleDateFormat.format(date);
        System.out.println(format); //2020-12-01 15:00:45
        String[] split = format.split("-");
        String s = split[0];
        System.out.println(s);
        String[] split2 = format.split(" ");
        System.out.println(split2[1]);
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



}
