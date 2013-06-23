package com.github.multicall.aggregators;

import java.util.LinkedList;
import java.util.List;

/**
*
*/
public class IntBean {
    private int primitive;
    private Integer object;

    public IntBean() {
    }

    public void setPrimitive(int primitive) {
        this.primitive = primitive;
    }

    public void setObject(Integer object) {
        this.object = object;
    }

    public int getPrimitive() {
        return primitive;
    }

    public Integer getObject() {
        return object;
    }

    public static List<IntBean> testCollection() {
        List<IntBean> bean = new LinkedList<IntBean>();
        bean.add(new IntBean() {{
            setObject(1);
            setPrimitive(2);
        }});
        bean.add(new IntBean() {{
            setObject(3);
            setPrimitive(4);
        }});
        return bean;
    }

}
