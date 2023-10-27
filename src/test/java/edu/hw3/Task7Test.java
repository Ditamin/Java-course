package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @Test
    @DisplayName("Добавление по null ключу")
    void basicTest() {
        TreeMap<String, String> tree = new TreeMap<>(Task7.TREE_WITH_NULL);
        tree.put(null, "test");
        Assertions.assertThat(tree.containsKey(null)).isTrue();
    }

    @Test
    @DisplayName("Смена значения по null ключу")
    void replaceTest() {
        TreeMap<String, String> tree = new TreeMap<>(Task7.TREE_WITH_NULL);
        tree.put("one", "first");
        tree.put(null, "test");
        tree.put(null, null);
        tree.put("two", "second");
        Assertions.assertThat(tree.get(null)).isEqualTo(null);
    }
}
