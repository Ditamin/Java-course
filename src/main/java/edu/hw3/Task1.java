package edu.hw3;

public class Task1 {
    private final static int ALPHABET_SIZE = 26;
    private final static char FIRST_LOWER_CASE_LETTER = 'a';
    private final static char FIRST_UPPER_CASE_LETTER = 'A';

    public String atbash(String str) {
        if (str == null) {
            return null;
        }

        StringBuilder encodedStr = new StringBuilder();

        for (int i = 0; i < str.length(); ++i) {
            char symbol = str.charAt(i);

            if (Character.isLetter(symbol) && (symbol < FIRST_LOWER_CASE_LETTER + ALPHABET_SIZE)) {
                if (symbol >= FIRST_LOWER_CASE_LETTER) {
                    encodedStr.append((char) (FIRST_LOWER_CASE_LETTER * 2 + ALPHABET_SIZE - symbol - 1));
                } else {
                    encodedStr.append((char) (FIRST_UPPER_CASE_LETTER * 2 + ALPHABET_SIZE - symbol - 1));
                }
            } else {
                encodedStr.append(symbol);
            }
        }

        return encodedStr.toString();
    }
}
