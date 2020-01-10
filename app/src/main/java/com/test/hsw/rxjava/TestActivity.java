package com.test.hsw.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.test.hsw.R;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class TestActivity extends Activity {
    private static final String tag = "Rachel_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        normalSubscribe();
        //除了 subscribe(Observer) 和 subscribe(Subscriber) ，subscribe() 还支持不完整定义的回调，RxJava 会自动根据定义创建出 Subscriber 。形式如下：
        subscribeAction();
        subscribeTransfromMap();
        subscribeTransfromMap1();
    }

    private void subscribeTransfromMap() {
        Log.d(tag, "------------------------------------subscribeTransfromMap-------------------------------------------------- ");
        //FuncX 和 ActionX 的区别在 FuncX 包装的是有返回值的方法。
        Observable.just("rachel") // 输入类型 String
                .map(new Func1<String, Student>() {
                    @Override
                    public Student call(String name) { // 参数类型 String
                        return new Student(name); // 返回类型 Student
                    }
                })
                .subscribe(new Action1<Student>() {
                    @Override
                    public void call(Student student) { // 参数类型 Student
                        Log.d(tag, student.getName());
                    }
                });
    }
    private void subscribeTransfromMap1() {
        Log.d(tag, "------------------------------------subscribeTransfromMap1-------------------------------------------------- ");
        //FuncX 和 ActionX 的区别在 FuncX 包装的是有返回值的方法。
        Observable.just("rachel") // 输入类型 String
                .map(new Func1<String, Student>() {
                    @Override
                    public Student call(String name) { // 参数类型 String
                        return new Student(name); // 返回类型 Student
                    }
                })
                .subscribe(new Observer<Student>() {
                    @Override
                    public void onCompleted() {
                        Log.d(tag, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(tag, "onError");
                    }

                    @Override
                    public void onNext(Student student) {
                        Log.d(tag, "onNext"+student.getName());
                    }
                });
    }

    /**
     * 01-10 11:54:20.225 2725-2725/com.test.hsw D/Rachel_test: 123
     * 01-10 11:54:20.225 2725-2725/com.test.hsw D/Rachel_test: 456
     * 01-10 11:54:20.225 2725-2725/com.test.hsw D/Rachel_test: 789
     */
    private void subscribeAction() {
        Log.d(tag, "------------------------------------normalSubscribe-------------------------------------------------- ");
        Action1<String> action = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
                Log.d(tag, s);
            }
        };
        String[] names = {"123", "456", "789"};
        Observable.from(names)
                .subscribe(action);
    }

    /**
     * 01-10 11:55:16.392 2918-2918/com.test.hsw D/Rachel_test: onStart!
     * 01-10 11:55:16.392 2918-2918/com.test.hsw D/Rachel_test: Item: Hello
     * 01-10 11:55:16.392 2918-2918/com.test.hsw D/Rachel_test: Item: Hi
     * 01-10 11:55:16.392 2918-2918/com.test.hsw D/Rachel_test: Item: Aloha
     * 01-10 11:55:16.392 2918-2918/com.test.hsw D/Rachel_test: Completed!
     */
    private void normalSubscribe() {
        Log.d(tag, "------------------------------------normalSubscribe-------------------------------------------------- ");
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                Log.d(tag, "Item: " + s);
            }

            /**
             *  事件队列完结。RxJava 不仅把每个事件单独处理，还会把它们看做一个队列。RxJava 规定，当不会再有新的 onNext() 发出时，需要触发 onCompleted() 方法作为标志。
             */
            @Override
            public void onCompleted() {
                Log.d(tag, "Completed!");
            }

            /**
             *  事件队列异常。在事件处理过程中出异常时，onError() 会被触发，同时队列自动终止，不允许再有事件发出。
             * @param e
             */
            @Override
            public void onError(Throwable e) {
                Log.d(tag, "Error!");
            }

            /**
             * onStart(): 这是 Subscriber 增加的方法。它会在 subscribe 刚开始，而事件还未发送之前被调用，可以用于做一些准备工作，例如数据的清零或重置。
             * 这是一个可选方法，默认情况下它的实现为空。需要注意的是，如果对准备工作的线程有要求（例如弹出一个显示进度的对话框，这必须在主线程执行），
             * onStart() 就不适用了，因为它总是在 subscribe 所发生的线程被调用，而不能指定线程。要在指定的线程来做准备工作，可以使用 doOnSubscribe() 方法，具体可以在后面的文中看到。
             */
            @Override
            public void onStart() {
                Log.d(tag, "onStart!");
            }
        };
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });

//        just(T...): 将传入的参数依次发送出来。
        Observable observable1 = Observable.just("Hello", "Hi", "Aloha");
// 将会依次调用：
// onNext("Hello");
// onNext("Hi");
// onNext("Aloha");
// onCompleted();
//        from(T[]) / from(Iterable<? extends T>) : 将传入的数组或 Iterable 拆分成具体对象后，依次发送出来。
        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observable2 = Observable.from(words);
// 将会依次调用：
// onNext("Hello");
// onNext("Hi");
// onNext("Aloha");
// onCompleted();
        observable.subscribe(subscriber);
    }
}
