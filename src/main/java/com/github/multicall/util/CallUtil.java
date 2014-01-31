package com.github.multicall.util;

import com.github.multicall.aggregators.AggregationException;

/**
 * Groups utility methods that operate on {@link Callable} instances.
 */
public class CallUtil {
    /**
     * Filters out throwables and wraps them into AggregationException
     * @param callable code to call
     * @param <V> return value type
     * @return value returned by the call
     * @throws AggregationException if a checked exception or a custom throwable occurs.
     * Runtime exceptions and errors are allowed to fly through normally.
     */
    public static <V> V call(Callable<V> callable) {
        try {
            return callable.call();
        } catch (RuntimeException e) {
            throw e;
        } catch (Error e) {
            throw e;
        } catch (Throwable t) {
            throw new AggregationException("Error invoking: [" + callable + "]", t);
        }
    }
}
