package com.test.hsw.factory.FactoryPattern;

public class Demo {

    /**
     * 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
     * <p>
     * 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
     *
     * 对工厂模式来说，变化就是构建对象的方式
     * @param args
     */
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore();

        //获取 CheesePizza 的对象，并调用它的 prepare 方法
        Pizza cheesePizza = store.orderPizza("cheese");

        //调用 CheesePizza 的 prepare 方法
        cheesePizza.prepare();

        //获取 BaconPizza 的对象，并调用它的 prepare 方法
        Pizza baconPizza = store.orderPizza("bacon");

        //调用 BaconPizza 的 prepare 方法
        baconPizza.prepare();
    }
}
