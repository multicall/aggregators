package com.github.multicall.util;

import java.util.Iterator;

public class ArrayIteratorWrapper<T> implements Iterable<T>{
    private T[] array;

    public ArrayIteratorWrapper(T[] array) {
        this.array = array;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(array);
    }
}
