package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

class Task8Test {
    @Test
    @DisplayName("Проход по массиву")
    void basicTest() {
        var it = new Task8.BackwardIterator<>(List.of(1, 2, 3));
        var passage = new ArrayList<Integer>();

        while (it.hasNext()) {
            passage.add(it.next());
        }

        Assertions.assertThat(passage).isEqualTo(List.of(3, 2, 1));
    }

    @Test
    @DisplayName("Выход за границу")
    void borderExceedTest() {
        var it = new Task8.BackwardIterator<>(new HashSet<>());
        Assertions.assertThatThrownBy(it::next).isInstanceOf(NoSuchElementException.class);
    }
}
