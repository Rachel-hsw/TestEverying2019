package com.test.hsw.可重入锁;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 和 synchronized 不一样，需要手动释放锁，所以使用 ReentrantLock的时候一定要手动释放锁，并且加锁次数和释放次数要一样
 * 由于加锁次数和释放次数不一样，第二个线程始终无法获取到锁，导致一直在等待。
 * 稍微改一下，在外层的finally里头释放9次，让加锁和释放次数一样，就没问题了
 */
public class WhatReentrant3 {
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
//							lock.unlock();// 这里故意注释，实现加锁次数和释放次数不一样
                        }
                    }
                } finally {
                    lock.unlock();
                    // 和上面那段注释的代码，是等价的。在外层的finally里头释放9次，让加锁和释放次数一样，就没问题了
//                    for (int i = 0; i < 9; i++) {
//                        lock.unlock();
//                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 20; i++) {
                        System.out.println("threadName:" + Thread.currentThread().getName());
                        try {
                            Thread.sleep(new Random().nextInt(200));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}

