package com.github.multicall.aggregators;

/**
 * Indicates error during aggregation. This is usually programmer's error, such as misusing stubs.
 */
public class AggregationException extends RuntimeException {
    public AggregationException(String message, Throwable cause) {
        super(message, cause);
    }
}
