package com.test.hsw.factory.AbstractFactoryPattern;

public class BaconPizza extends Pizza {

    public BaconPizza(IngredientFactory factory) {
        super(factory);
    }

    @Override
    public void prepare() {

    }

    @Override
    public void bake() {

    }
}