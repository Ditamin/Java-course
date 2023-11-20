package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @ParameterizedTest
    @ValueSource(strings = {"А012ВЕ345", "К678МН890", "О111РС111", "Т000УХ999"})
    void rightRuAutoSignTest(String sign) {
        Assertions.assertThat(Task5.ruAutoSignValidator(sign)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123АВЕ777", "А123ВГ77", " А012ВЕ345", "Б000ГД000", "А012ВЕ345."})
    void falseRuAutoSignTest(String sign) {
        Assertions.assertThat(Task5.ruAutoSignValidator(sign)).isEqualTo(false);
    }
}
