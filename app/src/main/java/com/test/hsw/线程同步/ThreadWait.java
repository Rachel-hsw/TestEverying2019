package com.test.hsw.线程同步;


import static com.test.hsw.线程同步.WaitNotifyTest.shareObj;

public class ThreadWait extends Thread {

    public ThreadWait(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (shareObj) {
            System.out.println("线程" + this.getName() + "开始等待");
            long startTime = System.currentTimeMillis();
            try {
                shareObj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i=0;
            while (true){
                if (i>10){
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("线程" + this.getName()
                    + "等待时间为：" + (endTime - startTime));

        }
        System.out.println("线程" + getName() + "等待结束");
    }
}

