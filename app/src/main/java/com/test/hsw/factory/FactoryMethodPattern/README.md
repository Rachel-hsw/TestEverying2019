简单工厂模式将构建对象的细节封装在一个静态方法中（静态方法无法被继承），而工厂方法模式将其封装在一个抽象方法中，这样子类可以通过重写抽象方法新增 pizza。
现在是介绍另一个设计原则的绝佳时机，它就是 “依赖倒置原则” ：上层组件不能依赖下层组件，并且它们都不能依赖具体，而应该依赖抽象。
上面的例子中PizzaStore是上层组件，CheesePizza是下层组件，如果直接在PizzaStore中构建CheesePizza就违反了依赖倒置原则，经过工厂模式的重构，PizzaStore依赖于Pizza这个抽象，同时CheesePizza也依赖于这个抽象。所以违反依赖倒置会让代码缺乏弹性，不易扩展。
Android 中RecyclerView.Adapter就运用了工厂方法模式：
public abstract static class Adapter<VH extends ViewHolder> {
    //封装了各式各样ViewHolder的构建细节，延迟实现构建细节到子类中
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);
}

作者：唐子玄
链接：https://juejin.im/post/5ccf031ee51d456e2a64b35d
来源：掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。