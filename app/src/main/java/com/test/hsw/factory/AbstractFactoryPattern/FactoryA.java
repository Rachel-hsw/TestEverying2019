package com.test.hsw.factory.AbstractFactoryPattern;

//具体工厂
public class FactoryA implements IngredientFactory{
    public Flour createFlour(){
        return new FlourA();
    }

    public Sause createSause(){
        return new SauseA();
    }
}

