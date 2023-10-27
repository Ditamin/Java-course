package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    Task2 task2 = new Task2();
    @Test
    @DisplayName("Обычный тест")
    void basicTest() {
        String str = "((()))(())()()(()())";
        String ans = "[((())), (()), (), (), (()())]";
        ArrayList<String> clusters = task2.clusterize(str);
        Assertions.assertThat(clusters.toString()).isEqualTo(ans);
    }

    @Test
    @DisplayName("Лишние левые скобки")
    void extraLeftBracket() {
        String str = "()(())(";
        String ans = "[(), (())]";
        ArrayList<String> clusters = task2.clusterize(str);
        Assertions.assertThat(clusters.toString()).isEqualTo(ans);
    }

    @Test
    @DisplayName("Лишние правые скобки")
    void extraRightBracket() {
        String str = ")()(()))";
        String ans = "[(), (())]";
        ArrayList<String> clusters = task2.clusterize(str);
        Assertions.assertThat(clusters.toString()).isEqualTo(ans);
    }

    @Test
    @DisplayName("Неверные символы")
    void invalidString() {
        String str = "({[]})";
        Assertions.assertThatThrownBy(() -> {
            task2.clusterize(str);
        }).isInstanceOf(IllegalStateException.class);
    }
}
