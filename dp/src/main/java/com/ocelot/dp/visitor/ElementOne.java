package com.ocelot.dp.visitor;

public class ElementOne implements Element {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
