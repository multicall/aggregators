package com.github.multicall.aggregators;

import com.github.multicall.aggregators.delegates.DelegateIterable;
import com.github.multicall.grabber.MethodCall;
import com.github.multicall.math.Arithmetics;

/**
 * Calculates sum of method return values.
 * Instances are immutable and thread safe.
 *
 * @param <T> Class of the objects to aggregate.
 * @param <V> Return type of the method call
 */
public class Sum<T, V extends Number> extends AbstractArrayAggregator<T, V, V> {
    private Arithmetics<V> arithmetics;

    /**
     * Creates new instance.
     *
     * @param call method call to use
     * @param arithmetics arithmetic mode to use
     */
    public Sum(MethodCall<T, V> call, Arithmetics<V> arithmetics) {
        super(call);
        this.arithmetics = arithmetics;
    }

    @Override
    protected V aggregate(Iterable<T> objects) throws Throwable {
        return arithmetics.sum(new DelegateIterable<T, V>(call, objects));
    }
}
