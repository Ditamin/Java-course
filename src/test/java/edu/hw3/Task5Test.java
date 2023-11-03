package edu.hw3;

import edu.hw3.Task5.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    Task5 task5 = new Task5();

    @Test
    @DisplayName("Сортировка по возрастанию")
    void ASCTest() {
        var names = new ArrayList<>(List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"));
        var sorted = task5.parseContacts(names, "ASC");
        ArrayList<Person> ans = new ArrayList<>(List.of(
            task5.new Person("Thomas Aquinas"),
            task5.new Person("Rene Descartes"),
            task5.new Person("David Hume"),
            task5.new Person("John Locke")));

        Assertions.assertThat(ans).isEqualTo(sorted);
    }

    @Test
    @DisplayName("Сортировка по убыванию")
    void DESCTest() {
        var names = new ArrayList<>(List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss"));
        var sorted = task5.parseContacts(names, "DESC");
        ArrayList<Person> ans = new ArrayList<>(List.of(
            task5.new Person("Carl Gauss"),
            task5.new Person("Leonhard Euler"),
            task5.new Person("Paul Erdos")));

        Assertions.assertThat(ans).isEqualTo(sorted);
    }

    @Test
    @DisplayName("Одинаковые фамилии")
    void sameLastNameTest() {
        var names = new ArrayList<>(List.of( "Vanya Ivanov", "Ivan Ivanov", "Michael Balakhontsev"));
        var sorted = task5.parseContacts(names, "ASC");
        ArrayList<Person> ans = new ArrayList<>(List.of(
            task5.new Person("Michael Balakhontsev"),
            task5.new Person("Ivan Ivanov"),
            task5.new Person("Vanya Ivanov")));

        Assertions.assertThat(ans).isEqualTo(sorted);
    }

    @Test
    @DisplayName("Имена без фамилии")
    void emptyLastNameTest() {
        var names = new ArrayList<>(List.of( "Vanya", "Ivan Ivanov", "Dima"));
        var sorted = task5.parseContacts(names, "ASC");
        ArrayList<Person> ans = new ArrayList<>(List.of(
            task5.new Person("Dima"),
            task5.new Person("Ivan Ivanov"),
            task5.new Person("Vanya")));

        Assertions.assertThat(ans).isEqualTo(sorted);
    }

    @Test
    @DisplayName("Пустой массив")
    void emptyDataTest() {
        var sorted = task5.parseContacts(new ArrayList<>(), "DESC");
        Assertions.assertThat(sorted.toString()).isEqualTo("[]");
    }

    @Test
    @DisplayName("Null массив")
    void nullDataTest() {
        var sorted = task5.parseContacts(null, "DESC");
        Assertions.assertThat(sorted.toString()).isEqualTo("[]");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "Ivan Ivanovich Ivanov"})
    @DisplayName("Некорректные имена")
    void emptyNameTest(String names) {
        Assertions.assertThatThrownBy(() -> {
            task5.parseContacts(new ArrayList<>(List.of(names)), "ASC");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Некорректный аргумент для компаратора")
    void invalidComparatorTest() {
        Assertions.assertThatThrownBy(() -> {
            task5.parseContacts(new ArrayList<>(List.of()), "larger");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
