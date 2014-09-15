package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.CallUtil;
import com.github.multicall.util.Callable;

/**
 * Calculates minimum for comparable objects.
 * @deprecated TODO Rewrite to extend AbstractArrayAggregator. DO NOT USE UNTIL THAT HAPPENS.
 */
public class Min<T, V extends Comparable<V>> extends AbstractIterableAggregator<T, V, Iterable<? extends T>> implements Callable<V> {
    /**
     * Creates new instance.
     *
     * @param objects collection of objects to operate on
     * @param call method call
     */
    public Min(Iterable<? extends T> objects, MethodCall<T, V> call) {
        super(objects, call);
    }

    public static <T, V extends Comparable<V>> V aggregate(Iterable<? extends T> objects, MethodCall<T, V> call) throws AggregationException {
        return CallUtil.call(new Min<T, V>(objects, call));
    }

    @Override
    public V call() throws Throwable {
        V min = null;
        for (T o : objects) {
            V value = call.replay(o);
            if (value != null && (min == null || min.compareTo(value) > 0)) {
                min = value;
            }
        }
        return min;
    }
}
