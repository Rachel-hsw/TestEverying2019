package com.test.hsw.factory.FactoryPattern;

/**
 * 如果PizzaStore一辈子只做这两种Type，上面的代码就很好，不需要重构。但如果需要新增Pizza类型，就不得不修改getShape()，向其中增加if-else。
 */
public class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        //构建具体pizza对象
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("bacon")) {
            pizza = new BaconPizza();
        }

        //使用pizza对象
        pizza.prepare();
        pizza.bake();
        return pizza;
    }
}
