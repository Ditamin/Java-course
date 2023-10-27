package edu.hw3;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Task8 {
    public static final class BackwardIterator<E> implements Iterator {
        private int cursor;
        private final E[] collection;

        BackwardIterator(Collection<E> collection) {
            this.collection = (E[]) collection.toArray();
            cursor = collection.size();
        }

        @Override
        public boolean hasNext() {
            return cursor > 0;
        }

        @Override
        public E next() {
            if (cursor == 0) {
                throw new NoSuchElementException();
            }

            return collection[--cursor];
        }
    }
}
