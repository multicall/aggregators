package com.github.multicall.aggregators;

/**
 * Top-level abstaction that provides access only to running the aggregation action on a given set of values.
 *
 * @param <T> Type of the object being aggregated
 * @param <R> Return value type
 */
public interface Aggregator<T, R> {
    /**
     * Executes aggregation
     * @param objects objects to aggregate
     * @return calculated value
     */
    R run(T... objects);

    /**
     * Executes aggregation
     * @param objects objects to aggregate
     * @return calculated value
     */
    R run(Iterable<T> objects);
}
