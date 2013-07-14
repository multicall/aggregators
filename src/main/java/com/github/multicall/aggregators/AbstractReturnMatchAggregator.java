package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;

/**
 * Provides default error handling behaviour for implementations of {@link ReturnMatchAggregator}.
 */
public abstract class AbstractReturnMatchAggregator<V> implements ReturnMatchAggregator<V> {
    @Override
    public <T, R extends V> R aggregate(Iterable<? extends T> objects, com.github.multicall.grabber.MethodCall<T, R> call) throws AggregationException {
        try {
            return calcBare(objects, call);
        } catch (RuntimeException e) {
            throw e;
        } catch (Error e) {
            throw e;
        } catch (Throwable t) {
            throw new AggregationException("Error invoking nested method", t);
        }
    }

    @SuppressWarnings("unchecked")
    public abstract <T, R extends V> R calcBare(Iterable<? extends T> objects, MethodCall<T, R> call) throws Throwable;
}
