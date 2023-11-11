package edu.hw5;

import java.util.regex.Pattern;

public class Task8 {
    private Task8() {}

    public static boolean isLenOdd(String s) {
        return Pattern.matches("^[01]([01]{2})*$", s);
    }

    public static boolean isLenUndFirstCharDiffParity(String s) {
        return Pattern.matches("^0([01]{2})*$|^1[01]([01]{2})*$", s);
    }

    public static boolean isNullAmountMiltipleOfThree(String s) {
        return Pattern.matches("^1*(1*01*01*01*)*$", s);
    }

    public static boolean isNot11Or111(String s) {
        return Pattern.matches("^[01]?$|^[01]{4,}$|^0+1?0*$|^1?0+$|^0+1?1$|^11?0+$|^101$", s);
    }

    public static boolean isEveryOddOne(String s) {
        return Pattern.matches("^(1[01])*1?$", s);
    }

    public static boolean isAtLeastTwoNullAnsOneUnit(String s) {
        return Pattern.matches("^0{2,}1?0*$|^0{1,}10{1,}$|^10{2,}$", s);
    }

    public static boolean isNotOnesInRow(String s) {
        return Pattern.matches("^0*(10+)*1?$", s);
    }
}
