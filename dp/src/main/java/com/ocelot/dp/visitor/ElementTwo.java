package com.ocelot.dp.visitor;

public class ElementTwo implements Element {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
