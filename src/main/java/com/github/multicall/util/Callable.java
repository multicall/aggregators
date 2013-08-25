package com.github.multicall.util;

/**
 * The exact copy of {@link java.util.concurrent.Callable} but throws {@link Throwable} instead of {@link Exception}
 * @param <V> the result type of method <tt>call</tt>
 */
public interface Callable<V> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Throwable if unable to compute a result
     */
    V call() throws Throwable;
}
