package com.test.hsw.Synchronized;

public class SynchronizedTest implements Runnable {
    public static int count = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 1000000; i++) {
            add();
        }
    }

    public synchronized void add() {
        ++count;
    }

    public static void main(String[] args) throws Exception {
        SynchronizedTest test = new SynchronizedTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count); //2000000
    }
}