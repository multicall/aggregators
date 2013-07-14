package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;

/**
 * Calculates maximum for comparable objects.
 */
public class Max extends AbstractReturnMatchAggregator<Comparable> {
    public final static Max INSTANCE = new Max();

    @Override
    @SuppressWarnings("unchecked")
    public <T, R extends Comparable> R calcBare(Iterable<? extends T> objects, MethodCall<T, R> call) throws Throwable {
        R max = null;
        for (T o : objects) {
            R value = call.replay(o);
            if (value != null && (max == null || max.compareTo(value) < 0)) {
                max = value;
            }
        }
        return max;
    }
}
