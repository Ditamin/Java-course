package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    Task5 task5 = new Task5();

    @Test
    @DisplayName("Число палиндром")
    void numIsPalindrome() {
        //given
        int num = 123321;
        //when
        boolean res = task5.isPalindromeDescendant(num);
        //then
        Assertions.assertThat(res).isEqualTo(true);
    }
    @Test
    @DisplayName("Число - одна цифра")
    void numIsDigit() {
        //given
        int num = 1;
        //when
        boolean res = task5.isPalindromeDescendant(num);
        //then
        Assertions.assertThat(res).isEqualTo(true);
    }

    @Test
    @DisplayName("Число имеет потомка палиндрома")
    void numHaveDescendantPalindrome() {
        //given
        int num = 11211230;
        //when
        boolean res = task5.isPalindromeDescendant(num);
        //then
        Assertions.assertThat(res).isEqualTo(true);
    }

    @Test
    @DisplayName("Число не имеет потомка палиндрома")
    void numHaveNotDescendantPalindrome() {
        //given
        int num = 111222;
        //when
        boolean res = task5.isPalindromeDescendant(num);
        //then
        Assertions.assertThat(res).isEqualTo(false);
    }

    @Test
    @DisplayName("Число c суммой пар цифр больше 9")
    void numWithPairSumOver9() {
        //given
        int num = 104756;
        //when
        boolean res = task5.isPalindromeDescendant(num);
        //then
        Assertions.assertThat(res).isEqualTo(true);
    }
}
