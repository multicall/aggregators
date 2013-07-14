package com.github.multicall.aggregators;

/**
 *
 */
public abstract class ReturnMatchAggregatorTest<T extends ReturnMatchAggregator> {
    protected final T subject;

    protected ReturnMatchAggregatorTest(T subject) {
        this.subject = subject;
    }

}
