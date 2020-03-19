package com.test.hsw.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {

    private static ReentrantLock lock;
    private static Condition condition;

    public static void main(String[] args) {
        testReentrant();
        //上面那把锁没释放，就不会继续往下走
        testReentrant();
    }

    private static void testReentrant() {
        lock = new ReentrantLock();
        condition = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 5) {
                    i++;
                    System.out.println(lock + "-------" + i);
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
        System.out.println(lock + "--------结束--------");
    }
}
