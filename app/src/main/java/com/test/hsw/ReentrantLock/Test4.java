package com.test.hsw.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Test4 {


    public static void main(String[] args) {
        testReentrant();
    }

    private static void testReentrant() {
        final ReentrantLock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
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
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 5) {
                    lock.lock();
                    i++;
                    System.out.println(lock + "-------" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
        System.out.println(lock + "--------结束--------");
    }
}
