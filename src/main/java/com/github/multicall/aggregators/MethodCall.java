package com.github.multicall.aggregators;

/**
 * Abstraction that describes method call.
 */
public interface MethodCall<T> {
    /**
     * Replays method call on a specified object. This method is rather expensive due to try-catch block and is intended for situations
     * when no thrown exception is allowed, such as iterator. Bulk operations should use a different approach (yet to implement).
     *
     * @param obj Object to call method on
     * @param <V> return value type
     * @return value returned by method
     */
    <V> V replay(T obj);

}
