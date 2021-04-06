package com.test.hsw.线程同步;


import static com.test.hsw.线程同步.WaitNotifyTest.shareObj;

public class ThreadNotify extends Thread {

    public ThreadNotify(String name){
        super(name);
    }


    @Override
    public void run() {
        try {
            // 给等待线程等待时间
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (shareObj) {
            System.out.println("线程" + this.getName() + "开始准备通知");
            shareObj.notifyAll();
            System.out.println("线程" + this.getName() + "通知结束");
        }
        System.out.println("线程" + this.getName() + "运行结束");
    }
}
