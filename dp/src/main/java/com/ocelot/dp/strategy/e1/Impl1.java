package com.ocelot.dp.strategy.e1;

public class Impl1 extends TemplateMethod1 {

    private int state = 1;

    @Override
    protected void start() {
        System.out.println("start   ");
    }

    @Override
    protected boolean nextTry() {
        System.out.println("nextTry-" + state++ + " ");
        return true;
    }

    @Override
    protected boolean isSolusion() {
        System.out.println("isSolution-" + (state == 3) + " ");
        return (state == 3);
    }

    @Override
    protected void stop() {
        System.out.println("stop");
    }
}
