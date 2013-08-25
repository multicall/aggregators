package com.github.multicall.util;

import com.github.multicall.aggregators.AggregationException;

/**
 * Groups utility methods that operate on {@link Callable} instances.
 */
public class CallUtil {
    /**
     * Filters out throwables and wraps them into
     * @param callable code to call
     * @param <V> return value type
     * @return value returned by the call
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
