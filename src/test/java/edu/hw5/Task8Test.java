package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "100", "01010"})
    void isLenOddReturnTrueTest(String s) {
        Assertions.assertThat(Task8.isLenOdd(s)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "10", "2", "0000"})
    void isLenOddReturnFalseTest(String s) {
        Assertions.assertThat(Task8.isLenOdd(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "01010", "100001"})
    void isLenUndFirstCharDiffParityReturnTrueTest(String s) {
        Assertions.assertThat(Task8.isLenUndFirstCharDiffParity(s)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "00", "2", "010101"})
    void isLenUndFirstCharDiffParityReturnFalseTest(String s) {
        Assertions.assertThat(Task8.isLenUndFirstCharDiffParity(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1111", "000", "01010", "10001010101"})
    void isNullAmountMultipleOfThreeReturnTrueTest(String s) {
        Assertions.assertThat(Task8.isNullAmountMiltipleOfThree(s)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10", "00", "2000", "0101010"})
    void isNullAmountMultipleOfThreeReturnFalseTest(String s) {
        Assertions.assertThat(Task8.isNullAmountMiltipleOfThree(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "0", "011", "01", "1111", "10", "101", "110", "011", "001"})
    void isNot11Or111ReturnTrueTest(String s) {
        Assertions.assertThat(Task8.isNot11Or111(s)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "111", "2"})
    void isNot11Or111ReturnFalseTest(String s) {
        Assertions.assertThat(Task8.isNot11Or111(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "101", "101010", "11111"})
    void isEveryOddOneReturnTrueTest(String s) {
        Assertions.assertThat(Task8.isEveryOddOne(s)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "121", "11011", "10100"})
    void isEveryOddOneReturnFalseTest(String s) {
        Assertions.assertThat(Task8.isEveryOddOne(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"00", "00001", "01000", "10000", "00000"})
    void isAtLeastTwoNullAnsOneUnitReturnTrueTest(String s) {
        Assertions.assertThat(Task8.isAtLeastTwoNullAnsOneUnit(s)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0110", "10", "00011", "10000010", ""})
    void isAtLeastTwoNullAnsOneUnitReturnFalseTest(String s) {
        Assertions.assertThat(Task8.isAtLeastTwoNullAnsOneUnit(s)).isEqualTo(false);
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "1", "0000", "10101", "010010001"})
    void isNotOnesInRowReturnTrueTest(String s) {
        Assertions.assertThat(Task8.isNotOnesInRow(s)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "102", "00011", "1011000010"})
    void isNotOnesInRowReturnFalseTest(String s) {
        Assertions.assertThat(Task8.isNotOnesInRow(s)).isEqualTo(false);
    }
}
