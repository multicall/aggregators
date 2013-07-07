package com.github.multicall.testutils;

import java.util.LinkedList;
import java.util.List;

/**
 * Utility methods usable in tests only.
 */
public class TestUtils {
    /**
     * Converts iterable into array.
     *
     * @param iterable iterable to convert
     * @return array of values from iteration
     */
    public static <T> Object[] toArray(Iterable<T> iterable) {
        List<T> list = new LinkedList<T>();

        for (T anIter : iterable) {
            list.add(anIter);
        }
        return list.toArray();
    }
}
