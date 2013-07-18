package com.github.multicall.aggregators.delegates;

import com.github.multicall.grabber.MethodCall;

import java.util.Iterator;

/**
 * Iterator on method result calls that will delegate the iteration to underlying iterable.
 * @param <T> object type.
 * @param <V> method return type. A 'convenience cast' only, no real type checking is present here.
 */
public class DelegateIterator<T, V> implements Iterator<V> {
    private Iterator<T> delegate;
    private MethodCall<T, V> call;

    /**
     * Creates new instance.
     * @param delegate iterator will delegate iteration here
     * @param call details on the method to call
     */
    public DelegateIterator(Iterator<T> delegate, MethodCall<T, V> call) {
        this.call = call;
        this.delegate = delegate;
    }

    @Override
    public boolean hasNext() {
        return delegate.hasNext();
    }

    @Override
    public V next() {
        return call.replayUnsafe(delegate.next());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This list is real-only");
//        delegate.remove();
    }
}
