
Scheduler ——调度器
相当于线程控制器，RxJava 通过它来指定每一段代码应该运行在什么样的线程。RxJava 已经内置了几个 Scheduler ，它们已经适合大多数的使用场景：
1、Schedulers.immediate(): 在当前线程运行，不指定线程。默认Scheduler。
2、Schedulers.newThread(): 总是启用新线程，并在新线程执行操作。
3、Schedulers.io(): I/O 操作（读写文件、读写数据库、网络信息交互等）所使用的 Scheduler。行为模式和 newThread() 差不多，区别在于 io() 的内部实现是是用一个无数量上限的线程池，可以重用空闲的线程，因此多数情况下 io() 比 newThread() 更有效率。
4、Schedulers.computation(): 计算所使用的 Scheduler。这个计算指的是 CPU 密集型计算，即不会被 I/O 等操作限制性能的操作，例如图形的计算。这个 Scheduler 使用的固定的线程池，大小为 CPU 核数。不要把 I/O 操作放在 computation() 中，否则 I/O 操作的等待时间会浪费 CPU。
另外， Android 还有一个专用的 AndroidSchedulers.mainThread()，它指定的操作将在 Android 主线程运行。

RxJava系列文章目录导读：--操作符用法详解
1、RxJava map- 一对一，事件对象的直接变换
2、RxJava flatMap - 一对多，返回的是个 Observable 对象
3、RxJava concatMap 一对多，顺序转换


ReentrantLock
https://www.cnblogs.com/takumicx/p/9338983.html
ReentrantLock(重入锁)功能详解和应用演示

目录
1. ReentrantLock简介
2. ReentrantLock和synchronized的相同点
2.1 ReentrantLock是独占锁且可重入的
3. ReentrantLock相比synchronized的额外功能
3.1 ReentrantLock可以实现公平锁。
3.2 .ReentrantLock可响应中断
3.3 获取锁时限时等待
4. 结合Condition实现等待通知机制
4.1 Condition使用简介
4.2 使用Condition实现简单的阻塞队列
5. 总结