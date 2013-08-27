package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.CallUtil;
import com.github.multicall.util.Callable;

/**
 * Calculates maximum for comparable objects.
 */
public class Max<T, V extends Comparable<V>> extends AbstractIterableAggregator<T, V, Iterable<? extends T>> implements Callable<V> {
    /**
     * Creates new instance.
     *
     * @param objects collection of objects to operate on
     * @param call method call
     */
    public Max(Iterable<? extends T> objects, MethodCall<T, V> call) {
        super(objects, call);
    }

    public static <T, V extends Comparable<V>> V aggregate(Iterable<? extends T> objects, MethodCall<T, V> call) throws AggregationException {
        return CallUtil.call(new Max<T, V>(objects, call));
    }

    @Override
    public V call() throws Throwable {
        V max = null;
        for (T o : objects) {
            V value = call.replay(o);
            if (value != null && (max == null || max.compareTo(value) < 0)) {
                max = value;
            }
        }
        return max;
    }
}
