package com.test.hsw.factory.AbstractFactoryPattern;

public class Demo {

    /**
     * 三种封装变化方式
     * 3、抽象工厂模式
     * 抽象工厂模式用来处理这种情况，它将构建一组对象的细节封装在一个接口中：
     */
    public static void main(String[] args) {
        PizzaStore store = new PizzaStoreA();

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
