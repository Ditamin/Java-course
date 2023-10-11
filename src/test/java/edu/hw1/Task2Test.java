package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    Task2 task2 = new Task2();

    @Test
    @DisplayName("Число = 0")
    void basicTest() {
        //given
        int num = 0;
        //when
        int numOfDigits = task2.countDigits(num);
        //then
        Assertions.assertThat(numOfDigits).isEqualTo(1);
    }

    @Test
    @DisplayName("Число c количеством цифр больше 1")
    void numWithDigitsOver1() {
        //given
        int num = 123;
        //when
        int numOfDigits = task2.countDigits(num);
        //then
        Assertions.assertThat(numOfDigits).isEqualTo(3);
    }

    @Test
    @DisplayName("Отрицательное число")
    void negativeNum() {
        //given
        int num = -20;
        //when
        int numOfDigits = task2.countDigits(num);
        //then
        Assertions.assertThat(numOfDigits).isEqualTo(2);
    }
}
