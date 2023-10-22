package edu.project1;

public class CommandHandler {
    private final static String SUCCESS = "Успех";
    private final static String EMPTY_ARGUMENT = "Отсутствует аргумент";

    private final Dictionary dictionary = new Dictionary();

    public String addWord(String arg) {
        try {
            if ((arg == null) || arg.isEmpty()) {
                throw new NullPointerException(EMPTY_ARGUMENT);
            }

            dictionary.add(arg);
        } catch (Exception e) {
            return e.getMessage();
        }

        return SUCCESS;
    }

    public String removeWord(String arg) {
        try {
            if ((arg == null) || arg.isEmpty()) {
                throw new NullPointerException(EMPTY_ARGUMENT);
            }

            dictionary.remove(arg);
        } catch (Exception e) {
            return e.getMessage();
        }

        return SUCCESS;
    }

    public String clear() {
        dictionary.clear();
        return SUCCESS;
    }

    public String getDictionary() {
        return dictionary.getAllWord();
    }

    public String startGame() {
        try {
            String hiddenWord = dictionary.getWord();
            Game game = new Game(hiddenWord);
            return game.start();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
