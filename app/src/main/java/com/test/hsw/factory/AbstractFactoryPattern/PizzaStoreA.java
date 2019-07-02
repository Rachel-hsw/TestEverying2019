package com.test.hsw.factory.AbstractFactoryPattern;

//A商店提供芝士和培根两种pizza
public class PizzaStoreA extends PizzaStore {
    @Override
    protected Pizza createPizza(String type){
        Pizza pizza = null;
        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }else if(type.equals("bacon")){
            pizza = new BaconPizza();
        }
        return pizza ;
    }
}
