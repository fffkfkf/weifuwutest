package atguigu.日期;

import org.junit.Test;

import java.time.*;
import java.util.Date;

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
