package com.test.hsw.factory.AbstractFactoryPattern;


//抽象pizza店
public abstract class PizzaStore{
    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        return pizza ;
    }
    //不同地区的pizza店可以推出地方特色的pizza
    protected abstract Pizza createPizza(String type) ;
}


