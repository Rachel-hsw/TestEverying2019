package com.test.hsw.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 本测试的目的：验证锁
 * 和Test2对比就会发现，由于2里面是公共变量，第二次创建的实例会把第一个覆盖掉，但是第一个并没有释放，所以最后会死锁
 * 并且请注意这是测试的不同线程的锁
 * 比如3，这是在同一线程获取的锁，同一线程内第一把锁没释放，第二把就进不去
 */
public class Test1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("--------子线程--------");
                testReentrant("子线程");
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testReentrant("主线程");
    }

    private static void testReentrant(final String name) {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 5) {
                    i++;
                    System.out.println(name+lock + "-------" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                lock.lock();
                condition.signal();
                lock.unlock();
            }
        }).start();
        lock.lock();
        try {
            condition.await(1000 * 20, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(name+lock + "--------结束--------");
    }
}
