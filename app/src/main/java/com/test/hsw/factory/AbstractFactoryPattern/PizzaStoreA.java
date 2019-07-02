package com.test.hsw.factory.AbstractFactoryPattern;

//A商店提供芝士和培根两种pizza
//构建pizza的时候传入具体工厂
public class PizzaStoreA extends PizzaStore{
    @Override
    protected Pizza createPizza(String type){
        Pizza pizza = null;
        FactoryA factory = new FactoryA();
        if(type.equals("cheese")){
            pizza = new CheesePizza(factory);
        }else if(type.equals("bacon")){
            pizza = new BaconPizza(factory);
        }
        return pizza ;
    }
}
