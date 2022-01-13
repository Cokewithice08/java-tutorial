package io.github.jast90.java.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/29 17:53
 */
public class LocalDates {

    public static void main(String[] args) throws ParseException {
//        localDate2String();
        format();
    }

    public static void format() {
        String pattern = "yyyy MM dd HH mm";
        pattern = "yyyy MM dd";
        String dateStr = "2021 6 11";
        DateTimeFormatter simpleDateFormatter1 = DateTimeFormatter.ofPattern(pattern);
        DateTimeFormatter simpleDateFormatter = new DateTimeFormatterBuilder()
                .parseLenient()
                .appendPattern(pattern)
//                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
//                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
//                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();
        LocalDate date = LocalDate.parse(dateStr, simpleDateFormatter);
        System.out.println(date);
    }

    public static void localDate2String() {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println(dateTime);
        System.out.println(date);
        System.out.println(time);
    }
}
