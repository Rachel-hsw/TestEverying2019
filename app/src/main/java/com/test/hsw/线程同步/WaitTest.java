package com.test.hsw.线程同步;

/**
 * https://blog.csdn.net/superjunenaruto/article/details/58315357
 */
public class WaitTest {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        synchronized (t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();
                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName() + " wait()");
                //不是使t1线程等待，而是当前执行wait的线程等待
                t1.wait();
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
