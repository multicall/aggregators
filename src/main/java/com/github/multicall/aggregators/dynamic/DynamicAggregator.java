package com.github.multicall.aggregators.dynamic;

import com.github.multicall.AbstractAggregator;
import com.github.multicall.aggregators.dynamic.delegates.DelegateCollection;
import com.github.multicall.aggregators.dynamic.delegates.DelegateIterable;
import com.github.multicall.aggregators.dynamic.delegates.DelegateList;
import com.github.multicall.aggregators.interceptors.CaptureInterceptor;

import java.util.Collection;
import java.util.List;

/**
 * This type of aggregator relies on delayed initialization by method calls that occur after the instance has been created.
 * This allows to provide any return value type at the cost of more complex and less strict syntax.
 * Instances of this aggregator are stateful and are <b>NOT THREAD SAFE</b>.
 * @param <T> type of the underlying bulk of objects.
 */
public class DynamicAggregator<T> extends AbstractAggregator<T> {
    // TODO consider writing thread safe version by using ThreadLocal. Subject to performance concerns.
    private CaptureInterceptor<T> interceptor;

    public DynamicAggregator(Class<T> clazz) {
        super(clazz);
    }

    /**
     * Creates new capture interceptor to capture method calls.
     *
     * @return Stub object that will record and remember details on one method call.
     * Only a single method call is allowed on this object, consequent calls will lead to {@link IllegalStateException}
     */
    public T stub() {
        interceptor = new CaptureInterceptor<T>();
        return spawn(interceptor);
    }

    /**
     * Flattens a list of objects into a list of method return values.
     * @see #flat(java.util.Collection, Object)
     */
    public <V> Iterable<V> flat(Iterable<T> objects, @SuppressWarnings("UnusedParameters") V capture) {
        return new DelegateIterable<T, V>(interceptor.getLastCall(), objects);
    }

    /**
     * Flattens collection of objects into a collection of method return values.<br/>
     * Example:<br/>
     * <code>
     *     <br/>Collection&lt;Number&gt numbers = ...;
     *     <br/>Collection&lt;Integer&gt; integers = a.flat(numbers, a.stub().intValue());
     * </code>
     * Collection returned by this method is lazy and backed by the original collection, see {@link DelegateCollection} for details.
     *
     * @param objects Collection of objects to aggregate
     * @param capture Method call on stub returned by calling {@code stub} method on this object
     * @param <V> Return value type of captured method
     * @return Collection of method return values.
     */
    public <V> Collection<V> flat(Collection<T> objects, @SuppressWarnings("UnusedParameters") V capture) {
        return new DelegateCollection<T, V>(interceptor.getLastCall(), objects);
    }

    /**
     * Flattens a list of objects into a list of method return values.
     * @see #flat(java.util.Collection, Object)
     */
    public <V> List<V> flat(List<T> objects, @SuppressWarnings("UnusedParameters") V capture) {
        return new DelegateList<T, V>(interceptor.getLastCall(), objects);
    }

    @SuppressWarnings("UnusedDeclaration")
    public <V> List<V> flat(Iterable<T> objects, Collection<V> collection, V capture) {
        // TODO Non-lazy flatten into user-specified collection
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @SuppressWarnings("UnusedDeclaration")
    public <V> V[] flat(Iterable<T> objects, V[] array, V capture) {
        // TODO Flatten into array
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
