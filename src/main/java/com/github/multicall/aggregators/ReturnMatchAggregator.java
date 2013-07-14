package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;

/**
 * Aggregator that takes a single method and have return type matching the return type of that method.
 *
 * @param <V> method return value type
 */
public interface ReturnMatchAggregator<V> {
    /**
     * Calculates aggregated value.
     *
     * @param objects objects to aggregate
     * @param call Method to use during aggregation
     * @param <T> Type of the object in the aggegated collection
     * @param <R> Method return type
     * @return Aggregation result
     * @throws AggregationException
     */
    <T, R extends V> R aggregate(Iterable<? extends T> objects, MethodCall<T, R> call) throws AggregationException;

}
