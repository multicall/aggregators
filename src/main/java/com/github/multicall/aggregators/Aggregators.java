package com.github.multicall.aggregators;

import com.github.multicall.aggregators.dynamic.DynamicAggregator;
import com.github.multicall.aggregators.stub.StubAggregator;

public class Aggregators {
    public static <T> StubAggregator<T> create(Class<T> clazz){
        return new StubAggregator<T>(clazz);
    }

    public static <T> DynamicAggregator<T> dynamic(Class<T> clazz){
        return new DynamicAggregator<T>(clazz);
    }
}
