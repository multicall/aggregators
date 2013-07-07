package com.github.multicall.aggregators.dynamic.delegates;

import com.github.multicall.aggregators.MethodCall;

import java.util.Iterator;

// TODO Javadoc
public class DelegateIterable<T, V> implements Iterable<V> {
    private MethodCall<T> call;
    private Iterable<T> objects;

    public DelegateIterable(MethodCall<T> call, Iterable<T> objects) {
        this.objects = objects;
        this.call = call;
    }

    @Override
    public Iterator<V> iterator() {
        return new DelegateIterator<T, V>(objects.iterator(), call);
    }
}
