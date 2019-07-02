package com.test.hsw.factory.AbstractFactoryPattern;

public class CheesePizza extends Pizza {


    public CheesePizza(IngredientFactory factory) {
        super(factory);
    }

    @Override
    public void prepare() {

    }

    @Override
    public void bake() {

    }
}