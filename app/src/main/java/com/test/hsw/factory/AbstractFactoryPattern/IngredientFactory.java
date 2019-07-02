package com.test.hsw.factory.AbstractFactoryPattern;

//抽象原料工厂（原材料构建者）
public interface IngredientFactory{
     Flour createFlour();
     Sause createSause();
}