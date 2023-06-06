package com.test.hsw.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                final Lock lock = new ReentrantLock();
                final Condition condition = lock.newCondition();

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(2000);
                        lock.lock();
                            System.out.println("唤醒锁。。。。。");
                        condition.signal();
                        lock.unlock();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(2000);
                            lock.lock();
                            System.out.println("唤醒锁。。。。。");
                            condition.signal();
                            lock.unlock();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                System.out.println("加锁。。。。。");
                //对线程加锁，等待
                lock.lock();
                try {
                    //设置等待时间1分钟
                    try {
                        condition.await(60 * 1000, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                    System.out.println("释放锁。。。。。");
                }


            }


        }).start();
    }
}
