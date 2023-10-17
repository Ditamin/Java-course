package edu.hw1;

public class Task4 {
    public String fixString(String str) {
        if (str == null) {
            throw new NullPointerException();
        }

        String fixedStr = "";

        for (int i = 0; i < str.length() / 2; ++i) {
            fixedStr += String.valueOf(str.charAt(2 * i + 1)) + String.valueOf(str.charAt(2 * i));
        }

        if (str.length() % 2 == 1) {
            fixedStr += str.charAt(str.length() - 1);
        }

        return fixedStr;
    }
}
