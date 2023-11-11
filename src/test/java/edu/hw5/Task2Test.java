package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    Task2 task2 = new Task2();

    @Test
    void getAllFridayTest() {
        int year = 1925;
        var res = task2.getAllFriday13InYear(year).toString();
        String ans = "[1925-02-13, 1925-03-13, 1925-11-13]";
        Assertions.assertThat(res).isEqualTo(ans);
    }

    @Test
    void nextFriday13FromFriday13Test() {
        LocalDate date = LocalDate.of(2023, 1, 13);
        var res = task2.getNextFriday13(date).toString();
        String ans = "2023-10-13";
        Assertions.assertThat(res).isEqualTo(ans);
    }

    @Test
    void nextFriday13InNextYearTest() {
        LocalDate date = LocalDate.of(2023, 11, 7);
        var res = task2.getNextFriday13(date).toString();
        String ans = "2024-09-13";
        Assertions.assertThat(res).isEqualTo(ans);
    }
}
