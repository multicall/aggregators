package com.github.multicall.grabber;

import com.github.multicall.grabber.impl.CaptureInterceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Captures method call to turn them into reusable objects. Sample:
 * <code>
 *     Grabber<Bean> g = Grabber.create(Bean.class);
 *     MethodCall<Bean, Double> getDouble = g.grab(g.stub().getDouble(), Double.TYPE);
 * </code>
 *
 * Instances are not tread safe and are intended for use in the static context.
 * @param <T> type of the object being grabbed.
 */
public class Grabber<T> {
    private CaptureInterceptor<T> interceptor;
    private Class<T> clazz;

    public static <T> Grabber<T> create(Class<T> clazz){
        return new Grabber<T>(clazz);
    }

    public Grabber(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Creates new capture interceptor to capture method calls.
     *
     * @return Stub object that will record and remember details on one method call.
     *         Only a single method call is allowed on this object, consequent calls will lead to {@link IllegalStateException}
     */
    public T stub() {
        interceptor = new CaptureInterceptor<T>();
        return spawn(interceptor);
    }

    /**
     * Returns last method call captured by this grabber.
     * @param capture value, returned by stub method call
     * @return Captured method call
     */
    public MethodCall<T, Object> grab(Object capture) {
        return grab(capture, Object.class);
    }

    /**
     * Returns last method call captured by this grabber.
     * @param capture value, returned by stub method call
     * @param clazz expected return type
     * @param <V> Method return value type
     * @return Captured method call
     */
    @SuppressWarnings("UnusedParameters")
    public <V> MethodCall<T, V> grab(V capture, Class<V> clazz) {
        return interceptor.getLastCall().returns(clazz);
    }


    @SuppressWarnings("unchecked")
    private T spawn(MethodInterceptor callback) {
        Enhancer enhancer = new Enhancer();
        if (clazz.isInterface()) {
            enhancer.setSuperclass(Object.class);
            enhancer.setInterfaces(new Class[]{clazz});
        } else {
            enhancer.setSuperclass(clazz);
        }
        enhancer.setCallback(callback);
        return (T) enhancer.create();
    }

}
