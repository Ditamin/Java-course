package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {
    private Task5() {}

    private static final Pattern RU_AUTO_SIGN = Pattern.compile(
        "^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{3}$");

    public static boolean ruAutoSignValidator(String sign) {
        return RU_AUTO_SIGN.matcher(sign).find();
    }
}
