package edu.hw1;

import java.util.Arrays;

public class Task6 {
    final int len = 4;
    final int notation = 10;
    final int minNum = 1000;
    final int maxNum = 10000;
    final int[] constKaprikara = {6, 1, 7, 4};

    private boolean allDigitSame(int num) {
        String str = String.valueOf(num);

        for (int i = 1; i < str.length(); ++i) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private void numToArray(int[] digits, int num) {
        int copy = num;

        for (int i = len - 1; i >= 0; --i) {
            digits[i] = copy % notation;
            copy /= notation;
        }
    }

    private void functionK(int[] digits) {
        int diff = 0;

        for (int i = 0; i < len; ++i) {
            diff = diff * notation + digits[len - i - 1] - digits[i];
        }

        numToArray(digits, diff);
    }

    public int countK(int num) {
        if ((num <= minNum) || (num >= maxNum) || allDigitSame(num)) {
            throw new IllegalStateException();
        }

        int count = 0;
        int[] digits = new int[len];
        numToArray(digits, num);

        while (!Arrays.equals(digits, constKaprikara)) {
            Arrays.sort(digits);
            functionK(digits);
            ++count;
        }

        return count;
    }
}
