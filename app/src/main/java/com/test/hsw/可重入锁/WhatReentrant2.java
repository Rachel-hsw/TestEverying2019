package com.test.hsw.可重入锁;


import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 可以发现没发生死锁，可以多次获取相同的锁
 * <p>
 * 可重入锁有
 * <p>
 * synchronized
 * ReentrantLock
 */
public class WhatReentrant2 {
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("第1次获取锁，这个锁是：" + lock);
                    int index = 1;
                    while (true) {
                        try {
                            lock.lock();
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + lock);
                            try {
                                Thread.sleep(new Random().nextInt(200));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (index == 10) {
                                break;
                            }
                        } finally {
                            lock.unlock();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
