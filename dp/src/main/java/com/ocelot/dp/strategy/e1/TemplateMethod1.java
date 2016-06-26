package com.ocelot.dp.strategy.e1;

public abstract class TemplateMethod1 implements Strategy {

    public void solve() {
        start();
        while (nextTry() && !isSolusion())
            ;
        stop();
    }

    protected abstract void start();

    protected abstract boolean nextTry();

    protected abstract boolean isSolusion();

    protected abstract void stop();
}
