package com.test.hsw.factory.SimpleFactoryPattern;

/**
 * 等等，这和我们平时将一段常用代码抽离出来放到Util类中有什么区别吗？
 * 是的，没有任何区别。从严格意义上说，这不是一个设计模式，更像是一种编程习惯。虽然只是代码搬家，但这种习惯的好处是：
 * 它隐藏了构建对象的细节，因为构建对象是经常会发生变化的，所以它还封装了变化，最后它还可以被复用，比如菜单类也需要
 * 构建 pizza 对象并获取他们的价格。
 * 使用静态方法是这类封装常用的技巧，它的好处是不需要新建工厂对象就可以实现调用，但缺点是不具备扩展性（静态方法不能被重写）。
 * 作者：唐子玄
 * 链接：https://juejin.im/post/5ccf031ee51d456e2a64b35d
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PizzaFactory{
    public static Pizza createPizza(String type){
        Pizza pizza = null;
        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }else if(type.equals("bacon")){
            pizza = new BaconPizza();
        }
        return pizza ;
    }
}

