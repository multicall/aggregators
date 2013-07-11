package com.github.multicall.grabber.impl;

import com.github.multicall.grabber.MethodCall;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Captures method call details to use them later in multicall agregation methods.
 */
public class CaptureInterceptor<T> implements MethodInterceptor {
    private InterceptedCall<T, Object> lastCall;

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (lastCall != null) {
            throw new IllegalStateException("Method invocation already captured. A stub can capture invocation only once.");
        } else {
            lastCall = new InterceptedCall<T, Object>(method, proxy, args);
            return null;
        }
    }

    /**
     * Returns method call captured by this interceptor.
     *
     * @return method call captured by this interceptor
     * @throws IllegalStateException if no method call was previously captured
     */
    public MethodCall<T, Object> getLastCall() {
        if (lastCall == null) {
            throw new IllegalStateException("Method invocation not captured before using dynamic aggregation method");
        }
        return lastCall;
    }

}
