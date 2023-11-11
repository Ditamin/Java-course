package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @ParameterizedTest
    @ValueSource(strings = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "|"})
    void oneCharRightPasswordCheckTest(String password) {
        Assertions.assertThat(Task4.passwordCheck(password)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"password!", "@mail.ru", "2 * 2"})
    void rightPasswordCheckTest(String password) {
        Assertions.assertThat(Task4.passwordCheck(password)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "_HaRd_PaSsWoRd_", ""})
    void invalidPasswordCheckTest(String password) {
        Assertions.assertThat(Task4.passwordCheck(password)).isEqualTo(false);
    }

    @Test
    void nullPasswordTest() {
        Assertions.assertThatThrownBy(() -> Task4.passwordCheck(null)).isInstanceOf(NullPointerException.class);
    }
}
