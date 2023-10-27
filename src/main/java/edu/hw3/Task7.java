package edu.hw3;

import java.util.Comparator;

public class Task7 {
    private Task7() {}

    public final static Comparator<Comparable> TREE_WITH_NULL = (o1, o2) -> {
        if (o1 == o2) {
            return 0;
        }

        if (o2 == null) {
            return 1;
        }

        if (o1 == null) {
            return -1;
        }

        return o1.compareTo(o2);
    };
}
