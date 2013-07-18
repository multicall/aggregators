package com.github.multicall.grabber;

/**
 * Abstraction that describes method call.
 * @param <T> Object type
 * @param <U> Method return type
 */
public interface MethodCall<T, U> {
    /**
     * Replays method call on a specified object. This method is rather expensive due to try-catch block and is intended for situations
     * when no thrown exception is allowed, such as inside iterator. Bulk operations should use a different approach (yet to implement).
     *
     * @param obj Object to call method on
     * @return value returned by method
     */
    U replayUnsafe(T obj);

    /**
     * Replays method call on a specified object.
     *
     * @param obj Object to call method on
     * @return value returned by method
     */
    U replay(T obj) throws Throwable;


    /**
     * Verifies return type of the method. This is the preferred way of initializing for static and reusable method call objects
     *
     * @param clazz expected return value class
     * @return MethodCall object compatible with specified return type if the latter is compatible if return type of the captured method
     * @throws ClassCastException if return types are not compatible
     */
    <V extends U> MethodCall<T, V> returns(Class<V> clazz);
}
