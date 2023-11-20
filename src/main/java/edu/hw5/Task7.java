package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {
    private Task7() {}

    public static boolean threeCharUndThirdNull(String str) {
        return Pattern.matches("^[01]{2}0[01]*$", str);
    }

    public static boolean firstUndLastCharEqual(String str) {
        return Pattern.matches("^([01])$|^(1[01]*1)$|^(0[01]*0)$", str);
    }

    public static boolean lenBetweenOneUndThree(String str) {
        return Pattern.matches("^[01]{1,3}$", str);
    }
}
