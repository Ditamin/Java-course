package edu.project1;

import java.util.HashSet;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Dictionary {
    private static final int MAX_WORD_LEN = 10;
    private static final int MIN_WORD_LEN = 2;
    private static final char FIRST_LETTER = 'a';
    private static final char LAST_LETTER = 'z';
    private final HashSet<String> words;

    Dictionary() {
        words = new HashSet<>();
    }

    void add(String word) throws IllegalStateException {
        String wordLowerCase = word.toLowerCase();

        for (int i = 0; i < wordLowerCase.length(); ++i) {
            if ((wordLowerCase.charAt(i) < FIRST_LETTER) || (wordLowerCase.charAt(i) > LAST_LETTER)) {
                throw new IllegalStateException("Некорректное слово");
            }
        }

        if (wordLowerCase.length() < MIN_WORD_LEN) {
            throw new IllegalStateException("Слово слишком короткое");
        }

        if (wordLowerCase.length() > MAX_WORD_LEN) {
            throw new IllegalStateException("Слово слишком длинное");
        }

        if (words.contains(wordLowerCase)) {
            throw new IllegalStateException("Такое слово уже добавлено");
        }

        words.add(wordLowerCase.toLowerCase(Locale.ROOT));
    }

    void remove(String removableWord) {
        String removableWordLowerCase = removableWord.toLowerCase();

        if (!words.contains(removableWordLowerCase)) {
            throw new NoSuchElementException("Слово не найдено");
        }

        words.remove(removableWordLowerCase);
    }

    String getAllWord() {
        return words.toString();
    }

    String getWord() {
        if (words.isEmpty()) {
            throw new NullPointerException("Словарь пуст, пожалуйста, добавьте в него слова");
        }

        int idx = (int) (Math.random() * words.size());
        int i = 0;
        String findedWord = null;

        for (var word : words) {
            if (idx == i) {
                findedWord = word;
            }

            ++i;
        }

        return findedWord;
    }

    void clear() {
        words.clear();
    }
}
