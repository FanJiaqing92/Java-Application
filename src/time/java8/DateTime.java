package time.java8;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * @ClassName DateTime
 * @Descripiton java8之前关于时间的api都太难用了，java8更新了更易用的时间api，总结一下用法
 * LocalDate: 实例是一个不可变对象，只包含日期信息，不附带任何与时区相关的信息
 * LocalTime: 只包含时间信息
 *
 *
 *
 *
 *
 * @Author Jiaqing Fan
 * @Date 2018/09/12
 */
public class DateTime {

    /**
     * LocalDate类的使用
     */
    public static void localDate(){
        //获取当前日期
        LocalDate nowDate = LocalDate.now();
        System.out.println("Current year: " + nowDate.getYear());
        System.out.println("Current month: " + nowDate.getMonth());
        System.out.println("Current month number: " + nowDate.getMonthValue());
        System.out.println("Current day of week: " + nowDate.getDayOfWeek());
        System.out.println("Current day of month: " + nowDate.getDayOfMonth());
        System.out.println("Current day of year: " + nowDate.getDayOfYear());

        //更多显示api自行探索

        //2个重载api
        LocalDate setDate1 = LocalDate.of(2015, 6, 29);
        System.out.println("setDate1: " + setDate1);
        LocalDate setDate2 = LocalDate.of(2015, Month.JUNE, 29);
        System.out.println("setDate2: " + setDate2);

        //如果字符串格式不正确，无法被解析，会抛出一个DateTimeParseException的错误
        LocalDate parseDate1 = LocalDate.parse("2015-06-30");
        System.out.println("parseDate1: " + parseDate1);
    }

    /**
     * LocalTime类的使用
     */
    public static void localTime(){
        //获取当前时间
        LocalTime nowTime = LocalTime.now();
        System.out.println("Current hour: " + nowTime.getHour());
        System.out.println("Current minute: " + nowTime.getMinute());
        System.out.println("Current second: " + nowTime.getSecond());
        //返回当前秒到下一秒，已经走过的纳秒数，[0, 999,999,999]
        System.out.println("Current nano: " + nowTime.getNano());

        //3个重载的api
        LocalTime setTime1 = LocalTime.of(12,12);
        System.out.println("setTime1: " + setTime1);
        LocalTime setTime2 = LocalTime.of(12,12,12);
        System.out.println("setTime2: " + setTime2);
        LocalTime setTime3 = LocalTime.of(12, 12,12,12);
        System.out.println("setTime3: " + setTime3);

        //如果字符串格式不正确，无法被解析，会抛出一个DateTimeParseException的错误
        LocalTime parseTime1 = LocalTime.parse("13:05:20");//这里貌似不能添加纳秒
        System.out.println("parseTime1: " + parseTime1);
    }

    /**
     * 合并LocalDate和LocalTime
     */
    public static void localDateTime(){
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("Current year: " + nowDateTime.getYear());
        System.out.println("Current month: " + nowDateTime.getMonth());
        System.out.println("Current month number: " + nowDateTime.getMonthValue());
        System.out.println("Current day of week: " + nowDateTime.getDayOfWeek());
        System.out.println("Current day of month: " + nowDateTime.getDayOfMonth());
        System.out.println("Current day of year: " + nowDateTime.getDayOfYear());
        System.out.println("Current hour: " + nowDateTime.getHour());
        System.out.println("Current minute: " + nowDateTime.getMinute());
        System.out.println("Current second: " + nowDateTime.getSecond());
        //返回当前秒到下一秒，已经走过的纳秒数，[0, 999,999,999]
        System.out.println("Current nano: " + nowDateTime.getNano());

        //这里举例2个of的重载方法，其他类似
        LocalDateTime setDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("setDateTime1: " + setDateTime1);
        LocalDateTime setDateTime2 = LocalDateTime.of(2016,8,31,12,02,33);
        System.out.println("setDateTime2: " + setDateTime2);

        //可以直接从LocalDateTime从获取LocalDate或者LocalTime
        LocalDate localDate = LocalDateTime.now().toLocalDate();
        System.out.println("localDate: " + localDate);
        LocalTime localTime = LocalDateTime.now().toLocalTime();
        System.out.println("localTime: " + localTime);
    }

    /**
     * 机器对于时间的建模更自然的表示是一个持续时间段上某个点的单一大整形数。以Unix元年（UTC时区1970年1月1日午夜时分）
     * 开始所经历的秒数。
     */
    public static void instant(){
        Instant nowInstant = Instant.now();
        System.out.println("Epoch Second: " + nowInstant.getEpochSecond());

        //传入秒数来创建一个实例
        Instant setInstant1 = Instant.ofEpochSecond(3);
        System.out.println("setInstant1 second: " + setInstant1.getEpochSecond());
        System.out.println("setInstant1 nano: " + setInstant1.getNano());
        //有一个重载版本还接受纳秒来对秒数进行调整。但会调整纳秒参数，确保保存的纳秒分片在[0, 999,999,999]内。就是说这
        //几个实例对象几乎相同
        Instant setInstant2 = Instant.ofEpochSecond(3, 0);
        System.out.println("setInstant2 second: " + setInstant2.getEpochSecond());
        System.out.println("setInstant2 nano: " + setInstant2.getNano());
        Instant setInstant3 = Instant.ofEpochSecond(2, 1_000_000_000);
        System.out.println("setInstant3 second: " + setInstant3.getEpochSecond());
        System.out.println("setInstant3 nano: " + setInstant3.getNano());
        Instant setInstant4 = Instant.ofEpochSecond(4, -1_000_000_000);
        System.out.println("setInstant1 second: " + setInstant4.getEpochSecond());
        System.out.println("setInstant1 nano: " + setInstant4.getNano());

        //这个类是为了方便机器使用，因此它无法处理那些我们非常容易理解的时间单位
        //下面这行代码就会抛出一个异常
        //int day = Instant.now().get(ChronoField.DAY_OF_MONTH);
    }
}
