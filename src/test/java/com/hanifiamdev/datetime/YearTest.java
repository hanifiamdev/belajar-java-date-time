package com.hanifiamdev.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class YearTest {

    @Test
    void create() {
        Year year1 = Year.now();
        Year year2 = Year.of(1980);
        Year year3 = Year.parse("2020");

        System.out.println(year1);
        System.out.println(year2);
        System.out.println(year3);

        YearMonth yearMonth1 = YearMonth.now();
        YearMonth yearMonth2 = YearMonth.of(1980, Month.JANUARY);
        YearMonth yearMonth3 = YearMonth.parse("2020-09");

        System.out.println(yearMonth1);
        System.out.println(yearMonth2);
        System.out.println(yearMonth3);

        MonthDay monthDay1 = MonthDay.now();
        MonthDay monthDay2 = MonthDay.of(Month.DECEMBER, 18);
        MonthDay monthDay3 = MonthDay.parse("--10-09");

        System.out.println(monthDay1);
        System.out.println(monthDay2);
        System.out.println(monthDay3);
    }

    @Test
    void konversi() {

        Year year = Year.now();

        LocalDate localDate = year.atMonth(Month.DECEMBER).atDay(19);
        System.out.println(localDate);

        MonthDay monthDay = MonthDay.from(localDate);
        System.out.println(monthDay);
    }

    @Test
    void get() {

        Year year = Year.now();
        YearMonth yearMonth = YearMonth.now();
        MonthDay mothDay = MonthDay.now();

        System.out.println(year.getValue());
        System.out.println(yearMonth.getYear());
        System.out.println(yearMonth.getMonth());
        System.out.println(mothDay.getMonth());
        System.out.println(mothDay.getDayOfMonth());

    }

}