package com.github.multicall.aggregators.collector;

import com.github.multicall.aggregators.AbstractChainingAggregator;
import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.CallUtil;

import java.util.List;

/**
 * see {@link #collect(Iterable, MethodCall, java.util.List)} description for details.
 * @deprecated TODO Rewrite to extend AbstractArrayAggregator. DO NOT USE UNTIL THAT HAPPENS.
 */
public class ListCollector<T, V, U extends Iterable<? extends T>, R extends List<V>> extends AbstractChainingAggregator<V, T, U, R> {
    public ListCollector(U objects, MethodCall<T, V> call, R list) {
        super(objects, call, list);
    }

    /**
     * Collects values returned by specified method into a list.
     *
     * @param objects collection to scan.
     * @param call method to use when resolving list item from an object
     * @param list list where objects will be added
     * @return the same list passed as parameter, for easy call chaining.
     */
    public static <T, V, U extends Iterable<? extends T>, R extends List<V>> R collect(final U objects, final MethodCall<T, V> call, final R list) {
        return CallUtil.call(new ListCollector<T, V, U, R>(objects, call, list));
    }

    @Override
    protected void execute() throws Throwable {
        for (T o : objects) {
            retVal.add(call.replay(o));
        }
    }

}
