package edu.hw1;

public class Task5 {
    final int notation = 10;

    private boolean isPalindrome(int num) {
        String str = String.valueOf(num);

        for (int i = 0; i < str.length() / 2; ++i) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    private int makeDescendant(int num) {
        String str = String.valueOf(num);
        int descendant = 0;

        if (str.length() % 2 == 1) {
            return 0;
        }

        for (int i = 0; i < str.length() / 2; ++i) {
            int sum = Character.digit(str.charAt(2 * i), notation) + Character.digit(str.charAt(2 * i + 1), notation);
            descendant = descendant * (sum >= notation ? notation * notation : notation) + sum;
        }

        return descendant;
    }

    public boolean isPalindromeDescendant(int num) {
        if (isPalindrome(num)) {
            return true;
        }

        int descendant = num;

        while (descendant > notation) {
            descendant = makeDescendant(descendant);

            if (isPalindrome(descendant) && (descendant > notation)) {
                return true;
            }
        }

        return false;
    }
}
