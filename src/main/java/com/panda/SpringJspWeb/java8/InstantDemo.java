package com.panda.SpringJspWeb.java8;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InstantDemo {

    public static void main(String[] args) {
        LocalDateTime plus = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).plus(300, ChronoUnit.MINUTES);
        System.out.println(1);
    }
}
