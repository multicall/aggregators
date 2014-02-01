package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.CallUtil;
import com.github.multicall.util.Callable;

import java.util.Iterator;

/**
 * Concatenates method return values into string.
 */
public class Concat<T, V> extends AbstractIterableAggregator<T, V, Iterable<? extends T>> implements Callable<String> {
    private final String separator;

    /**
     * Creates new instance.
     *
     * @param objects collection of objects to operate on
     * @param call method call
     * @param separator  d
     */
    protected Concat(Iterable<? extends T> objects, MethodCall<T, V> call, String separator) {
        super(objects, call);
        this.separator = separator;
    }

    public static <T, V> String aggregate(Iterable<? extends T> objects, MethodCall<T, V> call) throws AggregationException {
        return aggregate(objects, call, "");
    }

    public static <T, V> String aggregate(Iterable<? extends T> objects, MethodCall<T, V> call, String separator) throws AggregationException {
        return CallUtil.call(new Concat<T, V>(objects, call, separator));
    }

    @Override
    public String call() throws Throwable {
        StringBuilder sb = new StringBuilder();
        Iterator<? extends T> it = objects.iterator();
        if (it.hasNext()) {
            sb.append(call.replay(it.next()));
            while (it.hasNext()) {
                sb.append(separator).append(call.replay(it.next()));
            }
        }
        return sb.toString();
    }
}
