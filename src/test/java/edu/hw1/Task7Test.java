package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    Task7 task7 = new Task7();

    @Test
    @DisplayName("Обычный сдвиг влево")
    void basicRotateLeft() {
        //given
        int n = 16;
        int shift = 2;
        //when
        int res = task7.rotateLeft(n, shift);
        //then
        Assertions.assertThat(res).isEqualTo(2);
    }

    @Test
    @DisplayName("Обычный сдвиг вправо")
    void basicRotateRight() {
        //given
        int n = 8;
        int shift = 2;
        //when
        int res = task7.rotateRight(n, shift);
        //then
        Assertions.assertThat(res).isEqualTo(2);
    }

    @Test
    @DisplayName("Сдвиг влево больший чем количество битов")
    void bigRotateLeft() {
        //given
        int n = 6;
        int shift = 10;
        //when
        int res = task7.rotateLeft(n, shift);
        //then
        Assertions.assertThat(res).isEqualTo(5);
    }

    @Test
    @DisplayName("Сдвиг вправо больший чем количество битов")
    void bigRotateRight() {
        //given
        int n = 11;
        int shift = 12;
        //when
        int res = task7.rotateRight(n, shift);
        //then
        Assertions.assertThat(res).isEqualTo(11);
    }

    @Test
    @DisplayName("Отрицательный сдвиг влево")
    void negativeRotateLeft() {
        //given
        int n = 6;
        int shift = -4;
        //when
        int res = task7.rotateLeft(n, shift);
        //then
        Assertions.assertThat(res).isEqualTo(3);
    }

    @Test
    @DisplayName("Отрицательный сдвиг вправо")
    void negativeRotateRight() {
        //given
        int n = 11;
        int shift = -10;
        //when
        int res = task7.rotateRight(n, shift);
        //then
        Assertions.assertThat(res).isEqualTo(14);
    }
}
