package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    Task3 task3 = new Task3();

    @Test
    @DisplayName("Вложенный")
    void nestedArray() {
        //given
        int[] first_arr = new int[] {2, 3, 4};
        int[] second_arr = new int[] {1, 5};
        //when
        boolean res = task3.isNestable(first_arr, second_arr);
        //then
        Assertions.assertThat(res).isEqualTo(true);
    }

    @Test
    @DisplayName("Выполняется только первое условие")
    void onlyFirstConditionTrue() {
        //given
        int[] first_arr = new int[] {1};
        int[] second_arr = new int[] {-2, -1};
        //when
        boolean res = task3.isNestable(first_arr, second_arr);
        //then
        Assertions.assertThat(res).isEqualTo(false);
    }

    @Test
    @DisplayName("Выполняется только второе условие")
    void onlySecondConditionTrue() {
        //given
        int[] first_arr = new int[] {4, 10, 100};
        int[] second_arr = new int[] {5, 1000};
        //when
        boolean res = task3.isNestable(first_arr, second_arr);
        //then
        Assertions.assertThat(res).isEqualTo(false);
    }

    @Test
    @DisplayName("Одинаковые массивы")
    void equalArray() {
        //given
        int[] first_arr = new int[] {1, 2, 3};
        int[] second_arr = new int[] {1, 2, 3};
        //when
        boolean res = task3.isNestable(first_arr, second_arr);
        //then
        Assertions.assertThat(res).isEqualTo(false);
    }

    @Test
    @DisplayName("Пустой массив")
    void emptyArray() {
        //given
        int[] first_arr = new int[] {0};
        int[] second_arr = new int[] {};
        //when
        boolean res = task3.isNestable(first_arr, second_arr);
        //then
        Assertions.assertThat(res).isEqualTo(false);
    }

    @Test
    @DisplayName("Null массив")
    void nullArray() {
        int[] first_arr = null;
        int[] second_arr = new int[] {};
        Assertions.assertThatThrownBy(() -> {
            task3.isNestable(first_arr, second_arr);
        }).isInstanceOf(NullPointerException.class);
    }
}
