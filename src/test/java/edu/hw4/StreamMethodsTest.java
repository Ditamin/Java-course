package edu.hw4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static edu.hw4.Animal.Sex.*;
import static edu.hw4.Animal.Type.*;

class StreamMethodsTest {
    ArrayList<Animal> animals = new ArrayList<>(List.of(
        new Animal("Skubi du", DOG, M, 10, 101, 20, true),
        new Animal("Sally", DOG, F, 8, 60, 15, false),
        new Animal("Tom", CAT, M, 4, 50, 14, false),
        new Animal("Musa", CAT, F, 9, 40, 10, true),
        new Animal("Ponyo", FISH, F, 1, 5, 6, false),
        new Animal("Charlotta the spider", SPIDER, F, 3, 1, 2, true),
        new Animal("Kesha", BIRD, M, 2, 20, 7, true)
    ));

    @Test
    @DisplayName("Сортировка по росту")
    void task1() {
        var ans = List.of(animals.get(5), animals.get(4), animals.get(6),
            animals.get(3), animals.get(2), animals.get(1), animals.get(0));
        Assertions.assertThat(StreamMethods.task1(animals)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Первые k тяжелых")
    void task2() {
        var ans = List.of(animals.get(0), animals.get(1), animals.get(2));
        Assertions.assertThat(StreamMethods.task2(animals, 3)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Сколько животных каждого вида")
    void task3() {
        HashMap<Animal.Type, Long> ans = new HashMap<>();
        ans.put(DOG, 2L);
        ans.put(CAT, 2L);
        ans.put(FISH, 1L);
        ans.put(SPIDER, 1L);
        ans.put(BIRD, 1L);

        Assertions.assertThat(StreamMethods.task3(animals)).isEqualTo(ans);
    }

    @Test
    @DisplayName("У какого животного самое длинное имя")
    void task4() {
        Assertions.assertThat(StreamMethods.task4(animals)).isEqualTo(animals.get(5));
    }

    @Test
    @DisplayName("Кого больше самцов или самок")

    void task5() {
        Assertions.assertThat(StreamMethods.task5(animals)).isEqualTo(F);
    }

    @Test
    @DisplayName("Самое тяжелое животное каждого вида")
    void task6() {
        HashMap<Animal.Type, Animal> ans = new HashMap<>();
        ans.put(DOG, animals.get(0));
        ans.put(CAT, animals.get(2));
        ans.put(SPIDER, animals.get(5));
        ans.put(BIRD, animals.get(6));
        ans.put(FISH, animals.get(4));

        Assertions.assertThat(StreamMethods.task6(animals)).isEqualTo(ans);
    }

    @Test
    @DisplayName("K-е самое старое животное")
    void task7() {
        Assertions.assertThat(StreamMethods.task7(animals, 4)).isEqualTo(animals.get(2));
    }

    @Test
    @DisplayName("Самое тяжелое животное среди животных ниже k см")
    void task8() {
        Assertions.assertThat(StreamMethods.task8(animals, 11).orElse(null)).isEqualTo(animals.get(4));
    }

    @Test
    @DisplayName("Сумма лап у животных")
    void task9() {
        Assertions.assertThat(StreamMethods.task9(animals)).isEqualTo(26);
    }

    @Test
    @DisplayName("Животных, возраст которых не совпадает с количеством лап")
    void task10() {
        var ans = new ArrayList<>(List.of(
            animals.get(0), animals.get(1), animals.get(3), animals.get(4), animals.get(5)));

        Assertions.assertThat(StreamMethods.task10(animals)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Животные, которые могут укусить и с ростом больше 100 см")
    void task11() {
        var ans = new ArrayList<>(List.of(animals.get(0)));

        Assertions.assertThat(StreamMethods.task11(animals)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Сколько животных, вес которых превышает рост")
    void task12() {
        Assertions.assertThat(StreamMethods.task12(animals)).isEqualTo(2);
    }

    @Test
    @DisplayName("Список животных, имена которых состоят из более чем двух слов")
    void task13() {
        var ans = new ArrayList<>(List.of(animals.get(5)));

        Assertions.assertThat(StreamMethods.task13(animals)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Есть ли в списке собака ростом более k см")
    void task14() {
        Assertions.assertThat(StreamMethods.task14(animals, 101)).isEqualTo(false);
    }

    @Test
    @DisplayName("Суммарный вес животных каждого вида, от k до l лет")
    void task15() {
        HashMap<Animal.Type, Integer> ans = new HashMap<>();
        ans.put(DOG, 15);
        ans.put(CAT, 24);
        ans.put(SPIDER, 2);
        ans.put(BIRD, 7);

        Assertions.assertThat(StreamMethods.task15(animals, 2, 9)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Список животных, отсортированный по виду, затем по полу, затем по имени")
    void task16() {
        var ans = new ArrayList<>(List.of(
            animals.get(2), animals.get(3), animals.get(0), animals.get(1),
            animals.get(6), animals.get(4), animals.get(5)
        ));

        Assertions.assertThat(StreamMethods.task16(animals)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки")
    void task17() {
        Assertions.assertThat(StreamMethods.task17(animals)).isEqualTo(true);
    }

    @Test
    @DisplayName("Найти самую тяжелую рыбку в 2-х или более списках")
    void task18() {
        var fishes = new ArrayList<>(List.of(
            new Animal("Nemo", FISH, M, 1, 4, 5, false),
            new Animal("Dori", FISH, F, 2, 8, 10, false)
        ));

        Assertions.assertThat(StreamMethods.task18(animals, fishes)).isEqualTo(fishes.get(1));
    }

    @Test
    @DisplayName("Животные, в записях о которых есть ошибки")
    void task19() {
        var animalsWithMistakes = new ArrayList<>(List.of(
            new Animal(null, null, null, -1, -1, -1, false),
            new Animal("God", null, M, 1000, 1000, 1000, false)
        ));

        Map<String, Set<ValidationError>> mistakes = new HashMap<>();

        mistakes.put(null, new HashSet<>(List.of(
                new ValidationError("Name", "Null"),
                new ValidationError("Type", "Null"),
                new ValidationError("Sex", "Null"),
                new ValidationError("Age", "InvalidData"),
                new ValidationError("Height", "InvalidData"),
                new ValidationError("Weight", "InvalidData")
        )));

        mistakes.put("God", new HashSet<>(List.of(
                new ValidationError("Type", "Null"),
                new ValidationError("Age", "InvalidData"),
                new ValidationError("Height", "InvalidData"),
                new ValidationError("Weight", "InvalidData")
        )));

        Assertions.assertThat(StreamMethods.task19(animalsWithMistakes)).isEqualTo(mistakes);
    }

    @Test
    @DisplayName("Сделать результат предыдущего задания более читабельным")
    void task20() {
        var animalsWithMistakes = new ArrayList<>(List.of(
            new Animal(null, null, null, -1, -1, -1, false),
            new Animal("God", null, M, 1000, 1000, 1000, false)
        ));

        Map<String, Set<String>> mistakes = new HashMap<>();

        mistakes.put(null, Set.of("Type", "Name", "Sex", "Age", "Height", "Weight"));
        mistakes.put("God", Set.of("Type", "Age", "Height", "Weight"));

        var res = StreamMethods.task20(StreamMethods.task19(animalsWithMistakes));

        Assertions.assertThat(res.size()).isEqualTo(mistakes.size());

        for (var elem : res.entrySet()) {
            Assertions.assertThat(Arrays.stream(elem.getValue().split("[?,] ")).collect(Collectors.toSet()))
                .isEqualTo(mistakes.get(elem.getKey()));
        }
    }
}
