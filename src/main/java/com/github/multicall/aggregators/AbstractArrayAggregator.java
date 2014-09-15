package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.ArrayIteratorWrapper;

/**
 * Shared code to support aggregators that can operate on a collection or array.
 */
abstract class AbstractArrayAggregator<T, V, R> extends AbstractAggregator<T, V> implements Aggregator<T, R> {
    protected AbstractArrayAggregator(MethodCall<T, V> call) {
        super(call);
    }

    @Override
    public R run(T... objects) {
        return run(new ArrayIteratorWrapper<T>(objects));
    }

    @Override
    public R run(Iterable<T> objects) {
        try {
            return aggregate(objects);
        } catch (RuntimeException e) {
            throw e;
        } catch (Error e) {
            throw e;
        } catch (Throwable t) {
            throw new AggregationException("Error invoking: [" + call + "]", t);
        }
    }

    protected abstract R aggregate(Iterable<T> objects) throws Throwable;
}
