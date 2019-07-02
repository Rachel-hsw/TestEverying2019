package com.test.hsw.factory.SimpleFactoryPattern;


public class PizzaStore{
    public Pizza orderPizza(String type){
        Pizza pizza = PizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        return pizza ;
    }
}

