package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.ArrayIteratorWrapper;

/**
 * TODO doc
 */
public abstract class AbstractArrayAggregator<T, V, R> extends AbstractAggregator<T, V> {
    protected AbstractArrayAggregator(MethodCall<T, V> call) {
        super(call);
    }

    public R run(T... objects) {
        return run(new ArrayIteratorWrapper<T>(objects));
    }

    public R run(Iterable <T> objects) {
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
