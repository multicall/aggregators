package com.github.multicall.aggregators.dynamic.interceptor;

import com.github.multicall.aggregators.MethodCall;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Captures method call details to use them later in multicall agregation methods.
 */
public class CaptureInterceptor<T> implements MethodInterceptor {
    private Call<T> lastCall;

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (lastCall != null) {
            throw new IllegalStateException("Method invocation already captured. A stub can capture invocation only once.");
        } else {
            lastCall = new Call<T>(proxy, args);
            return null;
        }
    }

    /**
     * Returns method call captured by this interceptor.
     *
     * @return method call captured by this interceptor
     * @throws IllegalStateException if no method call was previously captured
     */
    public Call<T> getLastCall() {
        if (lastCall == null) {
            throw new IllegalStateException("Method invocation not captured before using dynamic aggregation method");
        }
        return lastCall;
    }

    private static class Call<T> implements MethodCall<T> {
        private MethodProxy method;
        private Object[] args;

        private Call(MethodProxy method, Object[] args) {
            this.method = method;
            this.args = args;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <V> V replay(T obj) {
            try {
                return (V) method.invoke(obj, args);
            } catch (Throwable t) {
                if (t instanceof RuntimeException) {
                    throw (RuntimeException) t; // Let CCE's and other runtimes fly
                } else {
                    throw new RuntimeException(t.getMessage(), t); // Indicates programmer's error
                }
            }
        }
    }
}
