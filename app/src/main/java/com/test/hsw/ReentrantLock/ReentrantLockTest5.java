package com.test.hsw.ReentrantLock;

/**
 * 4.2 使用Condition实现简单的阻塞队列
 * 阻塞队列是一种特殊的先进先出队列,它有以下几个特点
 * 1.入队和出队线程安全
 * 2.当队列满时,入队线程会被阻塞;当队列为空时,出队线程会被阻塞。
 *
 * 阻塞队列的简单实现
 * 5. 总结
 * ReentrantLock是可重入的独占锁。比起synchronized功能更加丰富，支持公平锁实现，支持中断响应以及限时等待等等。可以配合一个或多个Condition条件方便的实现等待通知机制。
 *
 */
public class ReentrantLockTest5 {

    public static void main(String[] args) throws InterruptedException {

        final MyBlockingQueue5<Integer> queue = new MyBlockingQueue5<>(2);
        for (int i = 0; i < 10; i++) {
            final int data = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.enqueue(data);
                    } catch (InterruptedException e) {

                    }
                }
            }).start();

        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Integer data = queue.dequeue();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
