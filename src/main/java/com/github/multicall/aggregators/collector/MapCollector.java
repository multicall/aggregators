package com.github.multicall.aggregators.collector;

import com.github.multicall.aggregators.AbstractIterableAggregator;
import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.CallUtil;
import com.github.multicall.util.Callable;

import java.util.Map;

public class MapCollector<T, V, U extends Iterable<? extends T>, R extends Map<V, T>> extends AbstractIterableAggregator<T, V, U, R> implements Callable<R> {
    private final R map;

    public MapCollector(U objects, MethodCall<T, V> call, R map) {
        super(objects, call);
        this.map = map;
    }

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
