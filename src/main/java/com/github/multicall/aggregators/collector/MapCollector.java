package com.github.multicall.aggregators.collector;

import com.github.multicall.aggregators.AbstractChainingAggregator;
import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.CallUtil;

import java.util.Map;

/**
 * Collects objects from collection into map using values, returned by specified method as key.
 * see {@link #collect(Iterable, com.github.multicall.grabber.MethodCall, java.util.Map)} description for details.
 * @deprecated TODO Rewrite to extend AbstractArrayAggregator. DO NOT USE UNTIL THAT HAPPENS.
 */
public class MapCollector<T, V, U extends Iterable<? extends T>, R extends Map<V, T>> extends AbstractChainingAggregator<V, T, U, R> {
    public MapCollector(U objects, MethodCall<T, V> call, R retVal) {
        super(objects, call, retVal);
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
    protected void execute() throws Throwable {
        for (T o : objects) {
            retVal.put(call.replay(o), o);
        }
    }
}
