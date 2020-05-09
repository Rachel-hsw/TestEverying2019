package com.test.hsw.AtomicBoolean;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by PC on 2018/4/28.
 * 乐观锁的主要实现方式 “CAS” 的技术原理
 */

public class TestAtomicBoolean implements Runnable {

    //使用给定的初始值创建新的 AtomicBoolean。
    public static AtomicBoolean exits = new AtomicBoolean(false);
    private String name;

    public TestAtomicBoolean(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //一般情况下，我们使用 AtomicBoolean 高效并发处理 “只初始化一次” 的功能要求：
        //如果当前状态值等于预期值，则以原子方式将同步状态设置为给定的更新值。
        //如果成功，则返回 true。返回 False 指示实际值与预期值不相等。
        boolean curent = exits.get();//返回当前值。
        System.out.println(curent);
        //compareAndSet(预期值， 新值)
        if (exits.compareAndSet(false, true)) {
            System.out.println(name + ",step 1");
            System.out.println(name + ",step 2");
            System.out.println(name + ",step 3");
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            exits.set(false);
        } else {
            System.out.println(name + ",step else");
        }
    }
}

