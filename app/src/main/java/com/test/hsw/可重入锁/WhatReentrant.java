package com.test.hsw.可重入锁;

/**
 * 可重入锁详解（什么是可重入）
 * https://blog.csdn.net/w8y56f/article/details/89554060
 * 什么是 “可重入”，可重入就是说某个线程已经获得某个锁，可以再次获取锁而不会出现死锁。
 * 可重入，就是可以重复获取相同的锁，synchronized和ReentrantLock都是可重入的
 * 可重入降低了编程复杂性
 */
public class WhatReentrant {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("第1次获取锁，这个锁是：" + this);
                    int index = 1;
                    while (true) {
                        synchronized (this) {
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + this);
                        }
                        if (index == 10) {
                            break;
                        }
                    }
                }
            }
        }).start();
    }
}
