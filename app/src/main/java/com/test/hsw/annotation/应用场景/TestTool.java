package com.test.hsw.annotation.应用场景;


import java.lang.reflect.Method;

/**
 * 提示 NoBug 类中的 chufa() 这个方法有异常，这个异常名称叫做 ArithmeticException，原因是运算过程中进行了除 0 的操作。
 * <p>
 * 所以，NoBug 这个类有 Bug。
 * <p>
 * 这样，通过注解我完成了我自己的目的，那就是对别人的代码进行测试。
 * <p>
 * 所以，再问我注解什么时候用？我只能告诉你，这取决于你想利用它干什么用。
 * ---------------------
 * 作者：frank909
 * 来源：CSDN
 * 原文：https://blog.csdn.net/briblue/article/details/73824058
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class TestTool {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //new一个NoBug对象
        NoBug testobj = new NoBug();
        //获取字节码文件
        Class clazz = testobj.getClass();
        //getMethods()	获得该类所有公有的方法 getDeclaredMethods()	获得该类所有方法
        Method[] method = clazz.getDeclaredMethods();
        //用来记录测试产生的 log 信息
        StringBuilder log = new StringBuilder();
        // 记录异常的次数
        int errornum = 0;
        for (Method m : method) {
            // 只有被 @Jiecha 标注过的方法才进行测试
            if (m.isAnnotationPresent(Jiecha.class)) {
                try {
                    //如果方法是 private修饰的,当你用反射去访问的时候 setAccessible(true); 之后 才能访问
                    m.setAccessible(true);
                    //invoke(Object obj, Object... args)	传递object对象及参数调用该对象对应的方法
                    //这里是遍历调用NoBug类的方法，参数为null
                    m.invoke(testobj, null);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    //e.printStackTrace();
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }
        log.append(clazz.getSimpleName());
        log.append(" has  ");
        log.append(errornum);
        log.append(" error.");
        // 生成测试报告
        System.out.println(log.toString());
    }
}


