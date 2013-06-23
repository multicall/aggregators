package com.github.multicall.aggregators;

public class Aggregators {
    public static <T> Aggregator<T> create(Class<T> clazz){
        return new Aggregator<T>(clazz);
    }

}
