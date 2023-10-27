package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    Task4 task4 = new Task4();

    @Test
    @DisplayName("Число из всех символов")
    void allLetterTest() {
        int arabicNum = 1666;
        String romanNum = task4.convertToRoman(arabicNum);
        Assertions.assertThat(romanNum).isEqualTo("MDCLXVI");
    }

    @Test
    @DisplayName("Число с не обычным порядком символов")
    void unusualOrderTest() {
        int arabicNum = 999;
        String romanNum = task4.convertToRoman(arabicNum);
        Assertions.assertThat(romanNum).isEqualTo("CMXCIX");
    }

    @Test
    @DisplayName("Число из большого количества одинаковых символов")
    void bigNumTest() {
        int arabicNum = 10000;
        String romanNum = task4.convertToRoman(arabicNum);
        Assertions.assertThat(romanNum).isEqualTo("MMMMMMMMMM");
    }

    @Test
    @DisplayName("Число не имеющая римского аналога")
    void notArabicNumTest() {
        int arabicNum = -1;
        Assertions.assertThatThrownBy(() -> {
            task4.convertToRoman(arabicNum);
        }).isInstanceOf(IllegalStateException.class);
    }
}
