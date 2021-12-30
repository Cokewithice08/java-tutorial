package io.github.jast90.java.api.concurrency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/30 10:12
 */
public class DateFormatConcurrencyTest {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            simpleDateFormatInConcurrency();

        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            dateTimeFormatterInConcurrency();
        }
    }


    public static void simpleDateFormatInConcurrency() {
        System.out.println("-----------simpleDateFormatInConcurrency start-----------");
        AtomicInteger sameCount = new AtomicInteger(0);
        AtomicInteger notSameCount = new AtomicInteger(0);
        ExecutorService executorService = new ThreadPoolExecutor(100, 100, 0L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setUncaughtExceptionHandler((t, e) -> {
                    notSameCount.incrementAndGet();
                });
                return thread;
            }
        });

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                LocalDate now = LocalDate.now();
                String dateStr = now.toString();
                Date parse = null;
                try {
                    parse = simpleDateFormat.parse(now.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String parseStr = mySimpleDateFormat.format(parse);
                if (!Objects.equals(dateStr, parseStr)) {
                    notSameCount.addAndGet(1);
                } else {
                    sameCount.addAndGet(1);
                }
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println(String.format("总结：sameCount:%s notSameCount:%s", sameCount.get(), notSameCount.get()));
                break;
            }
        }
        System.out.println("-----------simpleDateFormatInConcurrency end-----------");
    }

    public static void dateTimeFormatterInConcurrency() {
        System.out.println("-----------dateTimeFormatterInConcurrency start-----------");
        ExecutorService executorService = new ThreadPoolExecutor(100, 100, 0L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        AtomicInteger sameCount = new AtomicInteger(0);
        AtomicInteger notSameCount = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                LocalDate now = LocalDate.now();
                String dateStr = now.toString();
                TemporalAccessor parse = dateTimeFormatter.parse(now.toString());
                DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String parseStr = myDateTimeFormatter.format(parse);
                if (Objects.equals(dateStr, parseStr)) {
                    sameCount.addAndGet(1);
                } else {
                    notSameCount.addAndGet(1);
                }
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println(String.format("总结：sameCount:%s notSameCount:%s", sameCount.get(), notSameCount.get()));
                break;
            }
        }
        System.out.println("-----------dateTimeFormatterInConcurrency end-----------");
    }
}

/*
输出结果：
-----------simpleDateFormatInConcurrency start-----------
总结：sameCount:58 notSameCount:42
-----------simpleDateFormatInConcurrency end-----------
-----------simpleDateFormatInConcurrency start-----------
总结：sameCount:81 notSameCount:19
-----------simpleDateFormatInConcurrency end-----------
-----------simpleDateFormatInConcurrency start-----------
总结：sameCount:75 notSameCount:25
-----------simpleDateFormatInConcurrency end-----------
-----------simpleDateFormatInConcurrency start-----------
总结：sameCount:77 notSameCount:23
-----------simpleDateFormatInConcurrency end-----------
-----------simpleDateFormatInConcurrency start-----------
总结：sameCount:97 notSameCount:3
-----------simpleDateFormatInConcurrency end-----------
-----------simpleDateFormatInConcurrency start-----------
总结：sameCount:87 notSameCount:13
-----------simpleDateFormatInConcurrency end-----------
-----------simpleDateFormatInConcurrency start-----------
总结：sameCount:90 notSameCount:10
-----------simpleDateFormatInConcurrency end-----------
-----------simpleDateFormatInConcurrency start-----------
总结：sameCount:99 notSameCount:1
-----------simpleDateFormatInConcurrency end-----------
-----------simpleDateFormatInConcurrency start-----------
总结：sameCount:97 notSameCount:3
-----------simpleDateFormatInConcurrency end-----------
-----------simpleDateFormatInConcurrency start-----------
总结：sameCount:91 notSameCount:9
-----------simpleDateFormatInConcurrency end-----------

-----------dateTimeFormatterInConcurrency start-----------
总结：sameCount:100 notSameCount:0
-----------dateTimeFormatterInConcurrency end-----------
-----------dateTimeFormatterInConcurrency start-----------
总结：sameCount:100 notSameCount:0
-----------dateTimeFormatterInConcurrency end-----------
-----------dateTimeFormatterInConcurrency start-----------
总结：sameCount:100 notSameCount:0
-----------dateTimeFormatterInConcurrency end-----------
-----------dateTimeFormatterInConcurrency start-----------
总结：sameCount:100 notSameCount:0
-----------dateTimeFormatterInConcurrency end-----------
-----------dateTimeFormatterInConcurrency start-----------
总结：sameCount:100 notSameCount:0
-----------dateTimeFormatterInConcurrency end-----------
-----------dateTimeFormatterInConcurrency start-----------
总结：sameCount:100 notSameCount:0
-----------dateTimeFormatterInConcurrency end-----------
-----------dateTimeFormatterInConcurrency start-----------
总结：sameCount:100 notSameCount:0
-----------dateTimeFormatterInConcurrency end-----------
-----------dateTimeFormatterInConcurrency start-----------
总结：sameCount:100 notSameCount:0
-----------dateTimeFormatterInConcurrency end-----------
-----------dateTimeFormatterInConcurrency start-----------
总结：sameCount:100 notSameCount:0
-----------dateTimeFormatterInConcurrency end-----------
-----------dateTimeFormatterInConcurrency start-----------
总结：sameCount:100 notSameCount:0
-----------dateTimeFormatterInConcurrency end-----------
 */

/*
以上输出可以得出结论：
SimpleDateFormat 线程不安全
DateTimeFormatter 线程安全
 */
