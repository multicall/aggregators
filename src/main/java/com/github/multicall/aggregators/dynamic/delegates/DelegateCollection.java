package com.github.multicall.aggregators.dynamic.delegates;

import com.github.multicall.aggregators.MethodCall;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

// TODO Javadoc
public class DelegateCollection<T, V> extends AbstractCollection<V> {
    private MethodCall<T> call;
    private Collection<T> objects;

    public DelegateCollection(MethodCall<T> call, Collection<T> objects) {
        this.call = call;
        this.objects = objects;
    }

    @Override
    public Iterator<V> iterator() {
        return new DelegateIterator<T, V>(objects.iterator(), call);
    }

    @Override
    public int size() {
        return objects.size();
    }
}
