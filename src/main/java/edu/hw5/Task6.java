package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    private Task6() {}

    public static boolean isSubStr(String s, String t) {
        Pattern stringPattern = Pattern.compile(s);
        return stringPattern.matcher(t).find();
    }
}
