package com.test.hsw.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.test.hsw.R;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 测试代码主要来自
 * 给 Android 开发者的 RxJava 详解
 * http://gank.io/post/560e15be2dca930e00da1083
 * https://segmentfault.com/a/1190000011358934
 * RxJava 系列文章
 * https://blog.csdn.net/johnny901114/article/details/51533282
 */
public class TestActivity extends Activity {
    private static final String tag = "Rachel_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        normalSubscribe();
        //除了 subscribe(Observer) 和 subscribe(Subscriber) ，subscribe() 还支持不完整定义的回调，RxJava 会自动根据定义创建出 Subscriber 。形式如下：
        subscribeAction();
        subscribeTransformMap();
        subscribeTransformMap1();
        //flatMap(): 这是一个很有用但非常难理解的变换
        subscribeTransformFlatMap();
        subscribeTransformConcatMap();
    }




    /**
     * 既要是多个线程完成任务，又要保持任务的顺序。
     */
    private void subscribeTransformConcatMap() {
        Log.d(tag, "------------------------------------subscribeTransformConcatMap：-------------------------------------------------- ");
        try {
            Observable.from(Arrays.asList(
                    "http://www.baidu.com/",
                    "http://www.google.com/",
                    "https://www.bing.com/"))
                    .concatMap(new Func1<String, Observable<String>>() {
                        @Override
                        public Observable<String> call(String s) {
                            return createIpObservableMultiThread(s);
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(String s) {

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取ip
    private synchronized Observable<String> createIpObservableMultiThread(final String url) {
        return Observable
                .create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        //https://segmentfault.com/a/1190000016155200
                        String ip = getIP(getDomain(url));
                        Log.i(tag, url + "->" + ip);
                        subscriber.onNext(ip);
                        subscriber.onCompleted();
                    }
                })
                .subscribeOn(Schedulers.io());
    }

    /**
     * 获取url对应的域名
     *
     * @param url
     * @return
     */
    public String getDomain(String url) {
        String result = "";
        int j = 0, startIndex = 0, endIndex = 0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '/') {
                j++;
                if (j == 2)
                    startIndex = i;
                else if (j == 3)
                    endIndex = i;
            }

        }
        result = url.substring(startIndex + 1, endIndex);
        return result;
    }

    /**
     * 通过域名获取真实的ip地址 (此方法需要在线程中调用)
     *
     * @param domain
     * @return
     */
    public String getIP(String domain) {
        String ipAddress = "";
        InetAddress iAddress = null;
        try {
            iAddress = InetAddress.getByName(domain);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (iAddress == null)
            Log.i("xxx", "iAddress ==null");
        else {
            ipAddress = iAddress.getHostAddress();
        }
        return ipAddress;

    }

    private void subscribeTransformFlatMap() {
        Log.d(tag, "------------------------------------subscribeTransformMap：打印出一组学生的名字-------------------------------------------------- ");
        //flatMap(): 这是一个很有用但非常难理解的变换，因此我决定花多些篇幅来介绍它。
        //首先假设这么一种需求：假设有一个数据结构『学生』，现在需要打印出一组学生的名字
        Student[] students = {new Student("student_alice"), new Student("student_beat"), new Student("student_cat")};
        Subscriber<String> subscriber1 = new Subscriber<String>() {
            @Override
            public void onNext(String name) {
                Log.d(tag, "打印出一组学生的名字:" + name);
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

        };
        Observable.from(students)
                .map(new Func1<Student, String>() {
                    @Override
                    public String call(Student student) {
                        return student.getName();
                    }
                })
                .subscribe(subscriber1);
        Log.d(tag, "------------------------------------subscribeTransformMap：打印出每个学生所需要修的所有课程的名称-------------------------------------------------- ");
//        那么再假设：如果要打印出每个学生所需要修的所有课程的名称呢？
//        （需求的区别在于，每个学生只有一个名字，但却有多个课程。）首先可以这样实现：
        Subscriber<Student> subscriber2 = new Subscriber<Student>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Student student) {
                List<Course> courses = student.getCourses();
                for (int i = 0; i < courses.size(); i++) {
                    Course course = courses.get(i);
                    Log.d(tag, "打印出每个学生所需要修的所有课程的名称:" + course.getName());
                }
            }
        };
        Observable.from(students).subscribe(subscriber2);
        Log.d(tag, "------------------------------------subscribeTransformFlatMap：打印出每个学生所需要修的所有课程的名称-------------------------------------------------- ");
//        依然很简单。那么如果我不想在 Subscriber 中使用 for 循环，而是希望 Subscriber 中直接传入单个的 Course 对象呢（这对于代码复用很重要）？
//        用 map() 显然是不行的，因为 map() 是一对一的转化，而我现在的要求是一对多的转化。那怎么才能把一个 Student 转化成多个 Course 呢？
//        这个时候，就需要用 flatMap() 了：
        Subscriber<Course> subscriber3 = new Subscriber<Course>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Course course) {
                Log.d(tag, "打印出每个学生所需要修的所有课程的名称flatMap:" + course.getName());
            }
        };
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.getCourses());
                    }
                })
                .subscribe(subscriber3);
//        从上面的代码可以看出， flatMap() 和 map() 有一个相同点：它也是把传入的参数转化之后返回另一个对象。
//        但需要注意，和 map() 不同的是， flatMap() 中返回的是个 Observable 对象，
//        并且这个 Observable 对象并不是被直接发送到了 Subscriber 的回调方法中。
    }

    /**
     * map(): 事件对象的直接变换，具体功能上面已经介绍过。它是 RxJava 最常用的变换。
     */
    private void subscribeTransformMap() {
        Log.d(tag, "------------------------------------subscribeTransformMap-------------------------------------------------- ");
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

    private void subscribeTransformMap1() {
        Log.d(tag, "------------------------------------subscribeTransformMap1-------------------------------------------------- ");
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
                        Log.d(tag, "onNext" + student.getName());
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
