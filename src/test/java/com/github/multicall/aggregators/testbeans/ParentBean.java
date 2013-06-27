package com.github.multicall.aggregators.testbeans;

public class ParentBean extends AbstractBean<NestedBean, ParentBean> {
    NestedBean nested;

    @Override
    public NestedBean getObject() {
        return nested;
    }

    @Override
    public void setObject(NestedBean object) {
        this.nested = object;
    }

    @Override
    protected ParentBean create(NestedBean value) {
        throw new UnsupportedOperationException();
    }
}
