package edu.hw1;

public class Task2 {
    public int countDigits(int num) {
        int copy = num;
        int counter = 1;
        final int notation = 10;

        if (copy < 0) {
            copy = -copy;
        }

        while (copy >= notation) {
            copy /= notation;
            ++counter;
        }

        return counter;
    }
}
