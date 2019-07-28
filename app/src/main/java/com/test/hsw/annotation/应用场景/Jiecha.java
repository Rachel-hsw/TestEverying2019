package com.test.hsw.annotation.应用场景;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们
//所以生命周期非常长
@Retention(RetentionPolicy.RUNTIME)
public @interface Jiecha {

}
