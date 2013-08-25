package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.Callable;

/**
 * Adds parameter pass-through feature to {@link AbstractIterableAggregator} that allows easy method chaining
 */
public abstract class AbstractChainingAggregator<V, T,  U extends Iterable<? extends T>, R> extends AbstractIterableAggregator<T, V, U> implements Callable<R> {
    protected R retVal;

    public AbstractChainingAggregator(U objects, MethodCall<T, V> call, R retVal) {
        super(objects, call);
        this.retVal = retVal;
    }

    @Override
    public R call() throws Throwable {
        execute();
        return retVal;
    }

    protected abstract void execute() throws Throwable;
}
