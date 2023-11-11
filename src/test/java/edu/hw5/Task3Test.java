package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    Task3 task3 = new Task3();

    @Test
    void dashFormatTest() {
        String str = "2020-10-10";
        LocalDate ans = LocalDate.of(2020, 10, 10);
        var res = task3.parseDate(str);
        Assertions.assertThat(res.orElse(null)).isEqualTo(ans);
    }

    @Test
    void dashFormatWithSingleNumsTest() {
        String str = "1-2-3";
        LocalDate ans = LocalDate.of(1, 2, 3);
        var res = task3.parseDate(str);
        Assertions.assertThat(res.orElse(null)).isEqualTo(ans);
    }

    @Test
    void slashFormatTest() {
        String str = "10/10/1976";
        LocalDate ans = LocalDate.of(1976, 10, 10);
        var res = task3.parseDate(str);
        Assertions.assertThat(res.orElse(null)).isEqualTo(ans);
    }

    @Test
    void slashFormatWithSingleNumsTest() {
        String str = "1/2/10";
        LocalDate ans = LocalDate.of(10, 2, 1);
        var res = task3.parseDate(str);
        Assertions.assertThat(res.orElse(null)).isEqualTo(ans);
    }

    @Test
    void todayFormatTest() {
        String str = "today";
        LocalDate ans = LocalDate.now();
        var res = task3.parseDate(str);
        Assertions.assertThat(res.orElse(null)).isEqualTo(ans);
    }

    @Test
    void tomorrowFormatTest() {
        String str = "tomorrow";
        LocalDate ans = LocalDate.now().plusDays(1);
        var res = task3.parseDate(str);
        Assertions.assertThat(res.orElse(null)).isEqualTo(ans);
    }

    @Test
    void yesterdayFormatTest() {
        String str = "yesterday";
        LocalDate ans = LocalDate.now().minusDays(1);
        var res = task3.parseDate(str);
        Assertions.assertThat(res.orElse(null)).isEqualTo(ans);
    }

    @Test
    void oneDayAgoFormatTest() {
        String str = "1 day ago";
        LocalDate ans = LocalDate.now().minusDays(1);
        var res = task3.parseDate(str);
        Assertions.assertThat(res.orElse(null)).isEqualTo(ans);
    }

    @Test
    void someDayAgoFormatTest() {
        String str = "2234 days ago";
        LocalDate ans = LocalDate.now().minusDays(2234);
        var res = task3.parseDate(str);
        Assertions.assertThat(res.orElse(null)).isEqualTo(ans);
    }

    @Test
    void unsupportedFormatTest() {
        String str = "2 days later";
        var res = task3.parseDate(str);
        Assertions.assertThat(res.isEmpty()).isEqualTo(true);
    }
}
