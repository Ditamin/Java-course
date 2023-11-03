package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    Task3 task3 = new Task3();

    @Test
    void arrayOfString() {
        String[] words = {"a", "b", "c", "a", "b", "a"};
        HashMap<String, Integer> ans = new HashMap<>();
        ans.put("a", 3);
        ans.put("b", 2);
        ans.put("c", 1);

        var dict = task3.freqDict(new ArrayList<>(List.of(words)));
        Assertions.assertThat(dict).isEqualTo(ans);
    }

    @Test
    void arrayOfInteger() {
        Integer[] nums = {1, 2, 2, 2};
        HashMap<Integer, Integer> ans = new HashMap<>();
        ans.put(1, 1);
        ans.put(2, 3);
        var dict = task3.freqDict(new ArrayList<>(List.of(nums)));
        Assertions.assertThat(dict).isEqualTo(ans);
    }

    @Test
    void setOfInteger() {
        Integer[] nums = {1, 2, 2, 3};
        HashMap<Integer, Integer> ans = new HashMap<>();
        ans.put(1, 1);
        ans.put(2, 1);
        ans.put(3, 1);
        var dict = task3.freqDict(new TreeSet<>(List.of(nums)));
        Assertions.assertThat(dict).isEqualTo(ans);
    }

    @Test
    void nullCollection() {
        Assertions.assertThatThrownBy(() -> {
            task3.freqDict(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
