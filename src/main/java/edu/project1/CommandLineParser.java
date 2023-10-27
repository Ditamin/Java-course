package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandLineParser {
    private static final String EXIT_CMD = "exit";
    private static final String START_CMD = "start";
    private static final String ADD_WORD = "add";
    private static final String REMOVE_WORD = "remove";
    private static final String CLEAR_DICTIONARY = "clear";
    private static final String GET_DICTIONARY = "dictionary";

    private static final String HELLO_MESSAGE = "Привет! введите одну из команд.";
    private static final String BYE_MESSAGE = "Пока!";

    private static final String HELP_MESSAGE = """
        Команды:
        - start
        - add <word>
        - remove <word>
        - clear
        - dictionary
        - exit
        """;

    private final static Logger LOGGER = LogManager.getLogger();
    private Scanner scanner = new Scanner(System.in);
    private final CommandHandler commandHandler = new CommandHandler();

    void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String input = null;
        LOGGER.info(HELLO_MESSAGE + "\n" + HELP_MESSAGE);

        while (!EXIT_CMD.equalsIgnoreCase(input)) {
            input = scanner.nextLine();
            String[] args = input.split(" ");
            String command = args[0];
            String option = args.length == 1 ? null : args[1];

            String res = switch (command) {
                case START_CMD -> commandHandler.startGame();
                case ADD_WORD -> commandHandler.addWord(option);
                case REMOVE_WORD -> commandHandler.removeWord(option);
                case CLEAR_DICTIONARY -> commandHandler.clear();
                case GET_DICTIONARY -> commandHandler.getDictionary();
                case EXIT_CMD -> BYE_MESSAGE;
                case null, default -> HELP_MESSAGE;
            };

            LOGGER.info(res);
        }
    }
}
