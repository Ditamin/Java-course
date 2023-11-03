package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    Task1 task1 = new Task1();

    @Test
    @DisplayName("Обычный тест")
    void basicTest() {
        String str = "Hello world! AaZz";
        String encodeStr = task1.atbash(str);
        Assertions.assertThat(encodeStr).isEqualTo("Svool dliow! ZzAa");
    }

    @Test
    @DisplayName("Не латинские буквы")
    void russianLettersTest() {
        String str = "Привет, мир!";
        String encodeStr = task1.atbash(str);
        Assertions.assertThat(encodeStr).isEqualTo("Привет, мир!");
    }

    @Test
    @DisplayName("Пустая строка")
    void emptyStrTest() {
        String str = "";
        String encodeStr = task1.atbash(str);
        Assertions.assertThat(encodeStr).isEqualTo("");
    }

    @Test
    @DisplayName("Null строка")
    void nullStr() {
        String str = null;
        String encodeStr = task1.atbash(str);
        Assertions.assertThat(encodeStr).isEqualTo(null);
    }
}
