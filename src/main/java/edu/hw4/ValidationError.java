package edu.hw4;

import java.util.HashSet;
import java.util.Set;

public record ValidationError(String fieldName, String errorMessage) {
    private final static String EMPTY = "Null";
    private final static String INVALID_DATA = "InvalidData";
    private final static int MAX_HEIGHT = 300;
    private final static int MAX_WEIGHT = 300;
    private final static int MAX_AGE = 300;
    private final static int MIN_HEIGHT = 1;
    private final static int MIN_WEIGHT = 1;
    private final static int MIN_AGE = 0;


    public static Set<ValidationError> check(Animal animal) {
        Set<ValidationError> mistakes = new HashSet<>();

        if (animal.name() == null) {
            mistakes.add(new ValidationError("Name", EMPTY));
        }

        if (animal.type() == null) {
            mistakes.add(new ValidationError("Type", EMPTY));
        }

        if (animal.sex() == null) {
            mistakes.add(new ValidationError("Sex", EMPTY));
        }

        if (animal.age() < MIN_AGE || animal.age() > MAX_AGE) {
            mistakes.add(new ValidationError("Age", INVALID_DATA));
        }

        if (animal.height() < MIN_HEIGHT || animal.height() > MAX_HEIGHT) {
            mistakes.add(new ValidationError("Height", INVALID_DATA));
        }

        if (animal.weight() < MIN_WEIGHT || animal.age() > MAX_WEIGHT) {
            mistakes.add(new ValidationError("Weight", INVALID_DATA));
        }

        return mistakes;
    }
}
