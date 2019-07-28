package com.test.hsw.annotation;

public class Hero {
    public void say() {

    }

    @Deprecated//编译器在编译阶段遇到这个注解时会发出提醒警告，告诉开发者正在调用一个过时的元素比如过时的方法、过时的类、过时的成员变量。被调用的方法上会出现横线
    public void speak() {

    }
}
