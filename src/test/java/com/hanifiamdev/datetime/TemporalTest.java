package com.hanifiamdev.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;

public class TemporalTest {

    @Test
    void temporal() {

        Temporal temporal1 = LocalTime.now();
        Temporal temporal2 = LocalDate.now();
        Temporal temporal3 = LocalDateTime.now();
        Temporal temporal4 = ZonedDateTime.now();
        Temporal temporal5 = Year.now();
        Temporal temporal6 = YearMonth.now();
        Temporal temporal7 = Instant.now();

    }

    @Test
    void temporalAmount() {

        Temporal temporal1 = LocalDateTime.now();
        Temporal temporal2 = temporal1.plus(Duration.ofHours(10));
        Temporal temporal3 = temporal1.plus(Period.of(0, 10, 10));

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
    }

    @Test
    void temporalUnit() {

        long between1 = ChronoUnit.SECONDS.between(LocalDateTime.now(), LocalDateTime.now().plusDays(10));
        long between2 = ChronoUnit.MINUTES.between(LocalDateTime.now(), LocalDateTime.now().plusDays(10));
        long between3 = ChronoUnit.DAYS.between(LocalDateTime.now(), LocalDateTime.now().plusDays(10));

        System.out.println(between1);
        System.out.println(between2);
        System.out.println(between3);
    }

    @Test
    void temporalField() {
        Temporal temporal = LocalDateTime.now();

        System.out.println(temporal.get(ChronoField.YEAR));
        System.out.println(temporal.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(temporal.get(ChronoField.DAY_OF_MONTH));
        System.out.println(temporal.get(ChronoField.HOUR_OF_DAY));
        System.out.println(temporal.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println(temporal.get(ChronoField.SECOND_OF_MINUTE));
        System.out.println(temporal.get(ChronoField.MILLI_OF_SECOND));
        System.out.println(temporal.get(ChronoField.NANO_OF_SECOND));

        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.get(ChronoField.MILLI_OF_SECOND);// solusi jika getMillis tidak tersedia pakailah get(Temporalfield)
    }

    @Test
    void temporalQuery() {

        Temporal temporal = LocalDateTime.now();

        List<Integer> integers = temporal.query(new TemporalQuery<List<Integer>>() {
            @Override
            public List<Integer> queryFrom(TemporalAccessor temporal) {
                ArrayList<Integer> list = new ArrayList<>();

                list.add(temporal.get(ChronoField.YEAR));
                list.add(temporal.get(ChronoField.MONTH_OF_YEAR));
                list.add(temporal.get(ChronoField.DAY_OF_MONTH));

                return list;
            }
        });
        System.out.println(integers);
    }

    @Test
    void temporalAdjuster() {

        Temporal temporal1  = LocalDate.now();
        System.out.println(temporal1);

        // Cara manual
        Temporal temporal2 = temporal1.with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                return LocalDate.of(
                  temporal.get(ChronoField.YEAR),
                  temporal.get(ChronoField.MONTH_OF_YEAR),
                  1
                );
            }
        });
        System.out.println(temporal2);

        // Cara otomatis
        Temporal temporal3 = temporal1.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(temporal3);
        Temporal temporal4 = temporal1.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(temporal4);
    }
}
