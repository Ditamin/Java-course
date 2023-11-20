package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.JANUARY;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class Task2 {
    static final int MONTHS_IN_YEAR = 12;
    static final int RIGHT_DAY = 13;
    static final DayOfWeek RIGHT_DAY_OF_WEEK = DayOfWeek.of(5);

    public ArrayList<LocalDate> getAllFriday13InYear(int year) {
        Calendar calendar = new GregorianCalendar(year, JANUARY, RIGHT_DAY);
        ArrayList<LocalDate> allFriday13 = new ArrayList<>();

        for (int m = 1; m <= MONTHS_IN_YEAR; ++m) {
            if (calendar.get(DAY_OF_WEEK) == FRIDAY) {
                allFriday13.add(LocalDate.of(
                    calendar.get(YEAR), calendar.get(MONTH) + 1, calendar.get(DAY_OF_MONTH)));
            }

            calendar.roll(MONTH, 1);
        }

        return allFriday13;
    }

    public LocalDate getNextFriday13(LocalDate curDate) {
        LocalDate friday = curDate.with(TemporalAdjusters.next(RIGHT_DAY_OF_WEEK));

        while (friday.getDayOfMonth() != RIGHT_DAY) {
            friday = friday.with(TemporalAdjusters.next(RIGHT_DAY_OF_WEEK));
        }

        return friday;
    }
}
