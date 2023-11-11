package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @ParameterizedTest
    @ValueSource(strings = {"000", "110", "01010101"})
    @DisplayName("Выполняется: Не менее 3 символов и третий символ 0")
    void rightStrForFirstConditionTest(String str) {
        Assertions.assertThat(Task7.threeCharUndThirdNull(str)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"00", "00100", "110112"})
    @DisplayName("Не выполняется: Не менее 3 символов и третий символ 0")
    void falseStrForFirstConditionTest(String str) {
        Assertions.assertThat(Task7.threeCharUndThirdNull(str)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1111", "010101010"})
    @DisplayName("Выполняется: Начинается и заканчивается одним символом")
    void rightStrForSecondConditionTest(String str) {
        Assertions.assertThat(Task7.firstUndLastCharEqual(str)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"01", "1010", "aba"})
    @DisplayName("Не выполняется: Начинается и заканчивается одним символом")
    void falseStrForSecondConditionTest(String str) {
        Assertions.assertThat(Task7.firstUndLastCharEqual(str)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "111", "10"})
    @DisplayName("Выполняется: Длина не менее 1 и не более 3")
    void rightStrForThirdConditionTest(String str) {
        Assertions.assertThat(Task7.lenBetweenOneUndThree(str)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "00100", "121"})
    @DisplayName("Не выполняется: Длина не менее 1 и не более 3")
    void falseStrForThirdConditionTest(String str) {
        Assertions.assertThat(Task7.lenBetweenOneUndThree(str)).isEqualTo(false);
    }
}
