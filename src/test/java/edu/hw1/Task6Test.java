package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    Task6 task6 = new Task6();

    @Test
    @DisplayName("Обычное число")
    void basicTest() {
        //given
        int num = 6621;
        //when
        int count = task6.countK(num);
        //then
        Assertions.assertThat(count).isEqualTo(5);
    }

    @Test
    @DisplayName("Постоянная Капрекара")
    void constKaprekara() {
        //given
        int num = 6174;
        //when
        int count = task6.countK(num);
        //then
        Assertions.assertThat(count).isEqualTo(0);
    }

    @Test
    @DisplayName("Число с одинаковыми цифрами")
    void numWithAllDigitSame() {
        int num = 1111;
        Assertions.assertThatThrownBy(() -> {
            task6.countK(num);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("Не четырёхзначное число")
    void invalidName() {
        int num = 10;
        Assertions.assertThatThrownBy(() -> {
            task6.countK(num);
        }).isInstanceOf(IllegalStateException.class);
    }
}
