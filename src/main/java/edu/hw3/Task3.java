package edu.hw3;

import java.util.Collection;
import java.util.HashMap;

public class Task3 {
    public HashMap<Object, Integer> freqDict(Collection<Object> objects) {
        if (objects == null) {
            throw new NullPointerException();
        }

        HashMap<Object, Integer> dict = new HashMap<>();

        for (var object : objects) {
            if (dict.containsKey(object)) {
                dict.put(object, dict.get(object) + 1);
            } else {
                dict.put(object, 1);
            }
        }

        return dict;
    }
}
