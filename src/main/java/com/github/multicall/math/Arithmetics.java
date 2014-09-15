package com.github.multicall.math;

import java.math.BigDecimal;

/**
 * An abstraction that defines arithmetic operation modes for primitives
 */
// TODO Rewrite using asm to prevent code duplication
public interface Arithmetics<T> {
    public final static Arithmetics<Double> DOUBLE = new Arithmetics<Double>(){
        @Override
        public Double sum(Iterable<Double> summands) {
            double s = 0;
            for (double v : summands) {
                s += v;
            }
            return s;
        }
    };

    public final static Arithmetics<Float> FLOAT = new Arithmetics<Float>(){
        @Override
        public Float sum(Iterable<Float> summands) {
            float s = 0;
            for (float v : summands) {
                s += v;
            }
            return s;
        }
    };

    public final static Arithmetics<Integer> INTEGER = new Arithmetics<Integer>(){
        @Override
        public Integer sum(Iterable<Integer> summands) {
            int s = 0;
            for (int v : summands) {
                s += v;
            }
            return s;
        }
    };

    public final static Arithmetics<Long> LONG = new Arithmetics<Long>(){
        @Override
        public Long sum(Iterable<Long> summands) {
            long s = 0;
            for (long v : summands) {
                s += v;
            }
            return s;
        }
    };

    public final static Arithmetics<BigDecimal> BIG_DECIMAL = new Arithmetics<BigDecimal>(){
        @Override
        public BigDecimal sum(Iterable<BigDecimal> summands) {
            BigDecimal s = BigDecimal.ZERO;
            for (BigDecimal v : summands) {
                s = s.add(v);
            }
            return s;
        }
    };


    T sum(Iterable<T> summands);
}
