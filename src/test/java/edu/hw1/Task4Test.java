package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    Task4 task4 = new Task4();

    @Test
    @DisplayName("Строка четной длины")
    void stringWithEvenLength() {
        //given
        String str = "1234";
        //when
        String fixedStr = task4.fixString(str);
        //then
        Assertions.assertThat(fixedStr).isEqualTo("2143");
    }

    @Test
    @DisplayName("Строка нечетной длины")
    void stringWithOddLength() {
        //given
        String str = "1";
        //when
        String fixedStr = task4.fixString(str);
        //then
        Assertions.assertThat(fixedStr).isEqualTo("1");
    }

    @Test
    @DisplayName("Null строка")
    void nullString() {
        Assertions.assertThatThrownBy(() -> {
            task4.fixString(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
