package com.dj.tennis.global.config;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public final class Kst {

    public static final ZoneId ZONE = ZoneId.of("Asia/Seoul");

    private Kst() {
    }

    public static ZonedDateTime now(Clock clock) {
        return ZonedDateTime.now(clock.withZone(ZONE));
    }

    public static ZonedDateTime of(int year, int month, int day, int hour, int minute) {
        return ZonedDateTime.of(year, month, day, hour, minute, 0, 0, ZONE);
    }

    public static LocalDateTime naive(ZonedDateTime t) {
        return t.withZoneSameInstant(ZONE).toLocalDateTime();
    }

    public static ZonedDateTime attach(LocalDateTime naive) {
        return naive.atZone(ZONE);
    }

    public static String weekdayKo(LocalDate d) {
        return d.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
    }

    public static boolean isWeekend(LocalDate d) {
        DayOfWeek w = d.getDayOfWeek();
        return w == DayOfWeek.SATURDAY || w == DayOfWeek.SUNDAY;
    }

    public static String dayLabel(LocalDate d) {
        return d.getMonthValue() + "/" + d.getDayOfMonth() + "(" + weekdayKo(d) + ")";
    }
}
