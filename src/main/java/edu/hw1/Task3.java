package edu.hw1;

public class Task3 {
    private int min(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; ++i) {
            min = Math.min(min, arr[i]);
        }

        return min;
    }

    private int max(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public boolean isNestable(int[] first, int[] second) throws NullPointerException {
        if ((first == null) || (second == null)) {
            throw new NullPointerException();
        }

        if ((first.length == 0) || (second.length == 0)) {
            return false;
        }

        return (min(first) > min(second)) && (max(first) < max(second));
    }
}
