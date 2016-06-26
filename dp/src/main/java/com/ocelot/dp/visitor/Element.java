package com.ocelot.dp.visitor;

public interface Element {

    /**
     * Element子类中的实现类相同
     *
     * public void accept(Visitor v) {
     *  v.visit(this);
     * }
     *
     * 为了能够获得正确的Element类型信息,实现类必须写在子类中
     * @param v
     */
    void accept(Visitor v);
}
