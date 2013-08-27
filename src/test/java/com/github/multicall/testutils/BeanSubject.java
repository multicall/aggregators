package com.github.multicall.testutils;

import com.github.multicall.grabber.MethodCall;

/**
 * Test interface to provide common abstraction layer between aggregators that have shared test parts.
 * Allows to build inheritance tree from such tests despite aggregators might be static.
 */
public interface BeanSubject {
    <T, V extends Comparable<V>> V aggregate(Iterable<T> beans, MethodCall<T, V> call);
}
