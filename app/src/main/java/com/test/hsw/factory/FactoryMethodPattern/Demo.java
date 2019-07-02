package com.test.hsw.factory.FactoryMethodPattern;

public class Demo {

    /**
     * 三种封装变化方式
     * 2、工厂方法模式
     * 简单工厂模式中，工厂能够构建几种对象是在编译之前就定义好的，如果想要新增另一种新对象，必须修改既有的工厂类。这不符合开闭原则。
     * 所以简单工厂模式对于新增对象类型这个场景来说显得不够有弹性。
     * 有没有办法不修改既有类就新增对象类型？
     * 工厂方法模式就可以做到，因为它采用了继承
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
