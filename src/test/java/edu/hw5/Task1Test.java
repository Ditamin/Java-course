package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    Task1 task1 = new Task1();

    @Test
    void basicTest() {
        String timeUsing = """
            2022-03-12, 20:20 - 2022-03-12, 23:50
            2022-04-01, 21:30 - 2022-04-02, 01:20""";
        var res = task1.averageTimeUsing(timeUsing);
        Assertions.assertThat(res).isEqualTo("3ч 40м");
    }

    @Test
    void usingOneMonthTest() {
        String timeUsing = """
            2022-03-12, 20:00 - 2022-04-12, 20:10""";
        var res = task1.averageTimeUsing(timeUsing);
        Assertions.assertThat(res).isEqualTo("744ч 10м");
    }

    @Test
    void InvalidDataTest() {
        String timeUsing = """
            6 november 2023 20:00 - 6 november 2023, 21:00""";
        Assertions.assertThatThrownBy(() -> {
            task1.averageTimeUsing(timeUsing);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void timeInAfterTimeOutTest() {
        String timeUsing = """
            2022-03-12, 20:00 - 2022-03-12, 19:00""";
        Assertions.assertThatThrownBy(() -> {
            task1.averageTimeUsing(timeUsing);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyDataTest() {
        String timeUsing = "";
        var res = task1.averageTimeUsing(timeUsing);
        Assertions.assertThat(res).isEqualTo("0ч 0м");
    }

    @Test
    void nullDataTest() {
        Assertions.assertThatThrownBy(() -> {
            task1.averageTimeUsing(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
