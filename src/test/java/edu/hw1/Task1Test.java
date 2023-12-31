package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    Task1 task1 = new Task1();

    @Test
    @DisplayName("Время в обычном формате")
    void basicTest() {
        // given
        String duration = "00:00";
        // when
        int durationInSeconds = task1.minutesToSeconds(duration);
        // then
        org.assertj.core.api.Assertions.assertThat(durationInSeconds).isEqualTo(0);
    }

    @Test
    @DisplayName("Минут больше чем 59")
    void minutesOver59() {
        // given
        String duration = "100:00";
        // when
        int durationInSeconds = task1.minutesToSeconds(duration);
        // then
        org.assertj.core.api.Assertions.assertThat(durationInSeconds).isEqualTo(6000);
    }

    @Test
    @DisplayName("Секунд больше чем 59")
    void secondsOver59() {
        // given
        String duration = "01:60";
        // when
        int durationInSeconds = task1.minutesToSeconds(duration);
        // then
        org.assertj.core.api.Assertions.assertThat(durationInSeconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Cтрока null")
    void emptyString() {
        // given
        String duration = null;
        // when
        int durationInSeconds = task1.minutesToSeconds(duration);
        // then
        org.assertj.core.api.Assertions.assertThat(durationInSeconds).isEqualTo(-1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa:aa", "20 minutes"})
    void invalidFormat(String duration) {
        int durationInSeconds = task1.minutesToSeconds(duration);
        org.assertj.core.api.Assertions.assertThat(durationInSeconds).isEqualTo(-1);
    }
}
