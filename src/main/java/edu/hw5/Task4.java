package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    private Task4() {}

    private final static Pattern SPEC_CHARS = Pattern.compile("[~!@#$%^&*|]");

    public static boolean passwordCheck(String password) {
        return SPEC_CHARS.matcher(password).find();
    }
}
