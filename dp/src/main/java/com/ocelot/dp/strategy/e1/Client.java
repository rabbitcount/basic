package com.ocelot.dp.strategy.e1;

public class Client {

    public static void clientCode(Strategy strategy) {
        strategy.solve();
    }

    public static void execute() {
        Strategy[] algorithms = {new Impl1(), new Impl2()};
        for (Strategy strategy : algorithms) {
            clientCode(strategy);
        }
    }

    public static void main(String[] args) {
        execute();
    }
}
