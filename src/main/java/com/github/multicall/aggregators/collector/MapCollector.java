package com.github.multicall.aggregators.collector;

import com.github.multicall.aggregators.AbstractIterableAggregator;
import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.CallUtil;
import com.github.multicall.util.Callable;

import java.util.Map;

/**
 * Collects objects from collection into map using values, returned by specified method as key.
 * see {@link #collect(Iterable, com.github.multicall.grabber.MethodCall, java.util.Map)} description for details.
 */
public class MapCollector<T, V, U extends Iterable<? extends T>, R extends Map<V, T>> extends AbstractIterableAggregator<T, V, U, R> implements Callable<R> {
    private final R map;

    public MapCollector(U objects, MethodCall<T, V> call, R map) {
        super(objects, call);
        this.map = map;
    }

    /**
     * Collects objects from collection into map using values, returned by specified method as key.
     *
     * @param objects collection to scan.
     * @param call method to use when resolving key
     * @param map map where objects will be added
     * @return the same map passed as parameter, for easy call chaining.
     */
    public static <T, V, U extends Iterable<? extends T>, R extends Map<V, T>> R collect(final U objects, final MethodCall<T, V> call, final R map) {
        return CallUtil.call(new MapCollector<T, V, U, R>(objects, call, map));
    }

    @Override
    public R call() throws Throwable {
        for (T o : objects) {
            map.put(call.replay(o), o);
        }
        return map;
    }

}
