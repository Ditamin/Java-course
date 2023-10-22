package edu.project1;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private static final String EXIT_CMD = "exit";
    private static final String INITIAL_MESSAGE = "Отгадайте слово";
    private static final String WORD_IS_MESSAGE = "Слово: ";
    private static final String WRONG_INPUT = "Некорректный ввод";
    private static final String REPEATING_LETTER = "Эта буква уже была";
    private static final String RIGHT_LETTER_MESSAGE = "Правильно";
    private static final String WRONG_LETTER_MESSAGE = "Не верно";
    private static final String GAME_OVER_MESSAGE = "Игра окончена ";
    private static final String LOSE_MESSAGE = "вы проиграли";
    private static final String WIN_MESSAGE = "вы победили";

    private static final char FIRST_LETTER = 'a';
    private static final char LAST_LETTER = 'z';
    private static final int ALPHABET_SIZE = LAST_LETTER - FIRST_LETTER + 1;
    private static final int MAX_ATTEMPT = 5;

    private final String hiddenWord;
    private final ArrayList<Integer> letterAmount;
    private final static Logger LOGGER = LogManager.getLogger();
    private Scanner scanner = new Scanner(System.in);

    Game(String word, Scanner scanner) {
        hiddenWord = word;
        letterAmount = new ArrayList<>(ALPHABET_SIZE);
        this.scanner = scanner;

        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            letterAmount.add(0);
        }

        for (int i = 0; i < word.length(); ++i) {
            int idx = word.charAt(i) - FIRST_LETTER;
            letterAmount.set(idx, letterAmount.get(idx) + 1);
        }
    }

    Game(String word) {
        hiddenWord = word;
        letterAmount = new ArrayList<>(ALPHABET_SIZE);

        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            letterAmount.add(0);
        }

        for (int i = 0; i < word.length(); ++i) {
            int idx = word.charAt(i) - FIRST_LETTER;
            letterAmount.set(idx, letterAmount.get(idx) + 1);
        }
    }

    public String start() {
        String input = null;
        int remainingAttempts = MAX_ATTEMPT;
        LOGGER.info(INITIAL_MESSAGE);

        while (remainingAttempts > 0) {
            int guessedAmount = printHiddenWord();

            if (guessedAmount == hiddenWord.length()) {
                return GAME_OVER_MESSAGE + WIN_MESSAGE;
            }

            printRemainingLetter();
            input = scanner.nextLine();

            if (input.equalsIgnoreCase(EXIT_CMD)) {
                return GAME_OVER_MESSAGE;
            }

            String res = answerHandler(input);
            LOGGER.info(res);

            if (res.equals(WRONG_LETTER_MESSAGE)) {
                --remainingAttempts;
                LOGGER.info("Осталось попыток: " + remainingAttempts);
            }
        }

        LOGGER.info(WORD_IS_MESSAGE + hiddenWord);
        return GAME_OVER_MESSAGE + LOSE_MESSAGE;
    }

    public void printRemainingLetter() {
        String output = "Оставшиеся буквы: ";

        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            if (letterAmount.get(i) != -1) {
                output += (char) (FIRST_LETTER + i) + " ";
            }
        }

        LOGGER.info(output);
    }

    public int printHiddenWord() {
        String output = WORD_IS_MESSAGE;
        int guessedAmount = 0;

        for (int i = 0; i < hiddenWord.length(); ++i) {
            if (letterAmount.get(hiddenWord.charAt(i) - FIRST_LETTER) == -1) {
                output += hiddenWord.charAt(i);
                ++guessedAmount;
            } else {
                output += '_';
            }
        }

        LOGGER.info(output);
        return guessedAmount;
    }

    public String answerHandler(String answer) {
        if (answer.length() != 1) {
            return WRONG_INPUT;
        }

        char letter = answer.toLowerCase().charAt(0);

        if ((letter < FIRST_LETTER) || (letter > LAST_LETTER)) {
            return WRONG_INPUT;
        }

        return switch (letterAmount.get(letter - FIRST_LETTER)) {
            case -1 -> REPEATING_LETTER;
            case 0 -> {
                letterAmount.set(letter - FIRST_LETTER, -1);
                yield WRONG_LETTER_MESSAGE;
            }
            default -> {
                letterAmount.set(letter - FIRST_LETTER, -1);
                yield RIGHT_LETTER_MESSAGE;
            }
        };
    }
}
