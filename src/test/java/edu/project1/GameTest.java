package edu.project1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static final String GAME_OVER_MESSAGE = "Игра окончена ";
    private static final String LOSE_MESSAGE = "вы проиграли";
    private static final String WIN_MESSAGE = "вы победили";

    CommandHandler commandHandler = new CommandHandler();
    @Test
    @DisplayName("Проверка команды exit")
    void exitTest() {
        String word = "test";
        String input = "exit";
        commandHandler.addWord(word);
        Game game = new Game(word);
        game.setScanner(new Scanner(input));
        Assertions.assertThat(game.start()).isEqualTo(GAME_OVER_MESSAGE);
    }

    @Test
    @DisplayName("Выйграшная игра")
    void winGameTest() {
        String word = "test";
        String input = "t\ns\ne";
        commandHandler.addWord(word);
        Game game = new Game(word);
        game.setScanner(new Scanner(input));
        Assertions.assertThat(game.start()).isEqualTo(GAME_OVER_MESSAGE + WIN_MESSAGE);
    }

    @Test
    @DisplayName("Проиграшная игра")
    void loseGameTest() {
        String word = "test";
        String input = "a\nb\nc\nd\nf";
        commandHandler.addWord(word);
        Scanner scanner = new Scanner(input);
        Game game = new Game(word);
        game.setScanner(new Scanner(input));
        Assertions.assertThat(game.start()).isEqualTo(GAME_OVER_MESSAGE + LOSE_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"b\n", "1\n", "aaa\n"})
    @DisplayName("Неправильный ввод или повторная буква не уменьшает количество попыток")
    void invalidInputTest(String firstInput) {
        String word = "aaa";
        String input = firstInput + "b\nc\nd\ne\na";
        commandHandler.addWord(word);
        Scanner scanner = new Scanner(input);
        Game game = new Game(word);
        game.setScanner(new Scanner(input));
        Assertions.assertThat(game.start()).isEqualTo(GAME_OVER_MESSAGE + WIN_MESSAGE);
    }
}
