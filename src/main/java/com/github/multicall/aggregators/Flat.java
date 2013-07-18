package com.github.multicall.aggregators;

import com.github.multicall.aggregators.delegates.DelegateCollection;
import com.github.multicall.aggregators.delegates.DelegateIterable;
import com.github.multicall.aggregators.delegates.DelegateList;
import com.github.multicall.grabber.MethodCall;

import java.util.Collection;
import java.util.List;

/**
 * Flattens collection into the same type of collection that contains method return values instead of original objects.
 * Unlike other aggregators, this implementation is static as JLS does not allow generics complex enough to make all
 * methods to share the same interface.
 */
public class Flat {
    /**
     * Flattens iterable of objects into a list of method return values. List returned by this method is lazy and backed by
     * the original collection, see {@link DelegateCollection} for details.
     * <b>CAUTION:</b> As a very simple implementation that relies on {@link java.util.AbstractList} is retrned
     * wrapping the linked list or other implementations that have poor random access complexity is generally not a good idea.
     * TODO Add a test and fix this problem
     *
     * @see #collection
     */
    public static <T, V> Iterable<V> iterable(Iterable<T> objects, MethodCall<T, V> call) {
        return new DelegateIterable<T, V>(call, objects);
    }

    /**
     * Flattens collection of objects into a collection of method return values.<br/><br/> Example:<br/>
     * <code>
     *     MethodCall<Number, Integer> intValue = g.grab(g.stub().intValue(), int.class);
     *     ...
     *     <br/>Collection&lt;Number&gt; numbers = ...;
     *     <br/>Collection&lt;Integer&gt; integers = Flat.collection(numbers, intValue);
     * </code>
     * Collection returned by this method is lazy and backed by the original collection, see {@link DelegateCollection} for details.
     *
     * @param objects Collection of objects to aggregate
     * @param call Method to use when resolving collection members
     * @return Collection of method return values.
     * @param <T> Object type
     * @param <V> Method return value type
     */
    public static <T, V> Collection<V> collection(Collection<T> objects, MethodCall<T, V> call) {
        return new DelegateCollection<T, V>(call, objects);
    }

    /**
     * Flattens a list of objects into a list of method return values.
     * @see #collection
     */
    public static <T, V> List<V> list(List<T> objects, MethodCall<T, V> call) {
        return new DelegateList<T, V>(call, objects);
    }


}
