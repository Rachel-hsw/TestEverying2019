package com.test.hsw.Synchronized;

/**
 * https://www.cnblogs.com/jlutiger/p/10548291.html
 * 一、synchronized知识
 * 　　在谈论synchronized之前，我们需要了解线程安全问题的主要诱因。线程安全问题的主要诱因如下：
 * 存在共享数据（也称为临界资源）
 * 存在多条线程共同操作这些共享数据
 * 　　而解决线程安全的根本方法就是：同一时刻有且只有一个线程在操作共享数据，其他线程必须等到该线程处理完数据后再对共享数据进行操作。
 * 基于上述，引入了互斥锁
 */
public class test {
    public static void main(String[] args) {

    }
}
