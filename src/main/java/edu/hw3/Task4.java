package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    final private static int ALPHABET_SIZE = 7;
    final private static int MAX_LETTER_AMOUNT = 4;
    final private static int STEP = 3;
    final private ArrayList<Integer> arabic = new ArrayList<>(List.of(1000, 500, 100, 50, 10, 5, 1));
    final private ArrayList<Character> roman = new ArrayList<>(List.of('M', 'D', 'C', 'L', 'X', 'V', 'I'));


    public String convertToRoman(int num) {
        if (num <= 0) {
            throw new IllegalStateException();
        }

        int numCopy = num;
        int idx = 0;
        StringBuilder convertedNum = new StringBuilder();

        while (idx < ALPHABET_SIZE) {
            if (idx > 0 && numCopy / arabic.get(idx) == MAX_LETTER_AMOUNT) {
                if (!convertedNum.isEmpty()) {
                    if (convertedNum.charAt(convertedNum.length() - 1) == roman.get(idx - 1)) {
                        convertedNum.deleteCharAt(convertedNum.length() - 1);
                        numCopy += arabic.get(idx - 1);
                    }
                }

                convertedNum.append(roman.get(idx));
                numCopy += arabic.get(idx);
                idx -= STEP;
            } else {
                while (numCopy >= arabic.get(idx)) {
                    convertedNum.append(roman.get(idx));
                    numCopy -= arabic.get(idx);
                }
            }

            ++idx;
        }

        return convertedNum.toString();
    }
}
