package edu.project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {
    CommandHandler commandHandler = new CommandHandler();

    @ParameterizedTest
    @ValueSource(strings = {"I", "veryLongWord", "mp3, REPEATED"})
    void addInvalidWord(String word) {
        commandHandler.addWord("repeated");
        commandHandler.addWord(word);
        String dictionary = commandHandler.getDictionary();
        org.assertj.core.api.Assertions.assertThat(dictionary).isEqualTo("[repeated]");
    }

    @Test
    void removeTest() {
        String word = "test";
        commandHandler.addWord(word);
        commandHandler.removeWord(word);
        commandHandler.removeWord(word);
        String dictionary = commandHandler.getDictionary();
        org.assertj.core.api.Assertions.assertThat(dictionary).isEqualTo("[]");
    }

    @Test
    void clearTest() {
        String[] words = {"first", "second"};

        for (var word : words) {
            commandHandler.addWord(word);
        }

        commandHandler.clear();
        String dictionary = commandHandler.getDictionary();
        org.assertj.core.api.Assertions.assertThat(dictionary).isEqualTo("[]");
    }
}
