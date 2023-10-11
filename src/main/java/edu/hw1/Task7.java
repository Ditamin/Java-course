package edu.hw1;

public class Task7 {
    public int rotateLeft(int n, int shift) {
        String binN = Integer.toBinaryString(n);
        int separator = (shift % binN.length() + binN.length()) % binN.length();
        binN = binN.substring(separator) + binN.substring(0, separator);
        return Integer.parseInt(binN, 2);
    }

    public int rotateRight(int n, int shift) {
        String binN = Integer.toBinaryString(n);
        int separator = (binN.length() - shift % binN.length()) % binN.length();
        binN = binN.substring(separator) + binN.substring(0, separator);
        return Integer.parseInt(binN, 2);
    }
}
