package com.github.multicall.util;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private int pos = 0;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return pos < array.length;
    }

    public T next() {
        return array[pos++];
    }

    public void remove() {
        throw new UnsupportedOperationException("Removing items from array is not supported");
    }
}
