package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class CommandLineParserTest {
    @Test
    @DisplayName("Проверка работают ли команды")
    void basicRunTest() {
        String input = """
            add right
            add wrong
            remove bbb
            dictionary
            clear
            exit""";
        CommandLineParser commandLineParser = new CommandLineParser();
        commandLineParser.setScanner(new Scanner(input));
        commandLineParser.run();
    }
}
