package com.github.multicall.aggregators.dynamic.delegates;

import com.github.multicall.aggregators.MethodCall;

import java.util.AbstractList;
import java.util.List;

// TODO Javadoc
public class DelegateList<T, V> extends AbstractList<V> {
    private MethodCall<T> call;
    private List<T> objects;

    public DelegateList(MethodCall<T> call, List<T> objects) {
        this.objects = objects;
        this.call = call;
    }

    @Override
    public V get(int index) {
        return call.replay(objects.get(index));
    }

    @Override
    public int size() {
        return objects.size();
    }
}

