package com.test.hsw.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 4. 结合Condition实现等待通知机制
 * 使用synchronized结合Object上的wait和notify方法可以实现线程间的等待通知机制。
 * ReentrantLock结合Condition接口同样可以实现这个功能。而且相比前者使用起来更清晰也更简单。
 * <p>
 * Condition接口在使用前必须先调用ReentrantLock的lock()方法获得锁。之后调用Condition接口的await()将释放锁,
 * 并且在该Condition上等待,直到有其他线程调用Condition的signal()方法唤醒线程。使用方式和wait,notify类似。
 * <p>
 * 这个不是很理解，两个线程，一个线程由另一个线程唤醒
 */
public class ReentrantLockTest4 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        lock.lock();//主线程获得锁，所以在执行await之前，子线程不会运行
        new Thread(new SignalThread()).start();
        System.out.println("主线程等待通知");
        try {
            //当前线程调用await方法后，线程将释放锁，并且将自己沉睡，等待唤醒，子线程获取到锁后，开始做事，完毕后，调用Condition的signalall方法
            // 唤醒刚刚沉睡的线程，沉睡线程恢复执行。
            condition.await();
            System.out.println("await");
        } finally {
            /*lock.unlock();*/
        }
        System.out.println("主线程恢复运行");
        new Thread(new LockThread()).start();//永远获得不了锁，因为前面的释放被我注释掉了
        // （可重入是指，同一个线程可以多次获得锁，但是获得多少次，就得释放多少次，不然其它线程就无法获得锁。这里我主线程没释放，所以子线程获得不了，子线程永远卡死）
    }

    static class SignalThread implements Runnable {

        @Override
        public void run() {
            //这里必须先获取锁，因为当前的线程不是condition的所有者。当前线程要获取锁之后，才能调用condition.signal();
            lock.lock();
            System.out.println("获得锁");
            try {
                // TODO: 2021/4/6 做事
                System.out.println("子线程运行中。。");
                Thread.sleep(1000 * 10);
                condition.signal();
                System.out.println("子线程通知");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("释放锁");
                lock.unlock();
            }
        }
    }

    static class LockThread implements Runnable {

        @Override
        public void run() {
            System.out.println("子线程2运行");
            lock.lock();
            System.out.println("子线程2获得锁");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("子线程2释放锁");
                lock.unlock();
            }
        }
    }
}
