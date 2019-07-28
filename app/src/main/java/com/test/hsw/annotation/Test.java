package com.test.hsw.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TestAnnotation(msg = "hello")//因为设置了默认值，所以这里也可以直接使用@TestAnnotation()
public class Test {

    @Check(value = "hi")//Check 这个注解只有 value 这个属性。所以可以这样应用,等价于@Check(value="hi")
            int a;


    @Perform//因为Perform注解没有任何属性，所以在应用这个注解的时候，括号都可以省略。
    public void testMethod() {
    }


    public void test1() {
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }

    @SuppressWarnings("deprecation")
//阻止警告的意思。之前说过调用被 @Deprecated 注解的方法后，编译器会警告提醒，而有时候开发者会忽略这种警告，他们可以在调用的地方通过 @SuppressWarnings 达到目的。
    public void test2() {
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }


    public static void main(String[] args) {
        //1、检阅注解在类上的注解
        //通过 Class 对象的 isAnnotationPresent() 方法判断Test这个类是否应用了 TestAnnotation 这个注解
        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            //如果使用了通过 getAnnotation() 方法来获取 Annotation 对象。
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            //输出注解的属性
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }
        //2、检阅注解在属性、方法上的注解
        try {
            //Field类	代表类的成员变量（成员变量也称为类的属性）
            Field a = Test.class.getDeclaredField("a");
            //如果方法是 private修饰的,当你用反射去访问的时候 setAccessible(true); 之后 才能访问
            a.setAccessible(true);
            //获取一个成员变量上的注解
            Check check = a.getAnnotation(Check.class);
            //输出注解的属性
            if (check != null) {
                System.out.println("check value:" + check.value());
            }
            //Method类	代表类的方法
            Method testMethod = Test.class.getDeclaredMethod("testMethod");

            if (testMethod != null) {
                // 获取方法中的注解
                Annotation[] ans = testMethod.getAnnotations();
                for (int i = 0; i < ans.length; i++) {
                    System.out.println("method testMethod annotation:" + ans[i].annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}



