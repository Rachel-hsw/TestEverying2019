package com.test.hsw.线程同步;

/**
 * https://www.cnblogs.com/eer123/p/7880789.html
 */
public class WaitNotifyTest {
    /**
     * 在多线程间共享的对象上使用wait
     */
    static String[] shareObj = { "true" };

    public static void main(String[] args) {
        // setPriority优先级表示重要程度或者紧急程度.但是能不能抢到资源也是不一定.
        ThreadWait threadWait1 = new ThreadWait("wait thread1");
        threadWait1.setPriority(2);
        ThreadWait threadWait2 = new ThreadWait("wait thread2");
        threadWait2.setPriority(3);
        ThreadWait threadWait3 = new ThreadWait("wait thread3");
        threadWait3.setPriority(4);

        ThreadNotify threadNotify =new ThreadNotify("notify thread");

        threadNotify.start();
        threadWait1.start();
        threadWait2.start();
        threadWait3.start();
        System.out.println("主线程结束---------------------------------");
    }
}
