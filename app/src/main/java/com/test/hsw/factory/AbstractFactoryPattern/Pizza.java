package com.test.hsw.factory.AbstractFactoryPattern;

//原材料使用者
public class Pizza{
    private Flour flour;
    private Sause sause;
    //使用组合持有构建者
    private IngredientFactory factory;

    //注入一个具体构建者
    //同一种pizza，在不同地区可能会有不同口味
    //那是因为虽然用的是同类原材料（抽象），当产地不同味道就不同（具体）
    public Pizza(IngredientFactory factory){
        this.factory = factory;
    }

    //使用具体工厂构建原材料（发生多态的地方）
    public void prepare(){
        flour = factory.createFlour();
        sause = factory.createSause();
    }

    public void bake(){}
    public void cut(){}
}

