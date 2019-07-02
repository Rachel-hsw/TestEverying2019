package com.test.hsw.factory.SimpleFactoryPattern;

public class Demo {

    /**
     * 三种封装变化方式
     * 1、简单工厂模式
     * 既然目的是消除orderPizza()中构建具体pizza的细节，那最直接的做法是，将他们提取出来放到另一个类中：新增PizzaFactory
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
