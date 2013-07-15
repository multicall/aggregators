package com.github.multicall.aggregators;

import com.github.multicall.aggregators.dynamic.DynamicAggregator;

public class Aggregators {

    public static <T> DynamicAggregator<T> dynamic(Class<T> clazz){
        return new DynamicAggregator<T>(clazz);
    }
}
