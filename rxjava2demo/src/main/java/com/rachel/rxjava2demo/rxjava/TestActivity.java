package com.rachel.rxjava2demo.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.rachel.rxjava2demo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * * 作者：itbird01
 * * 链接：https://www.jianshu.com/p/d53463e1c3d6
 * * 来源：简书
 * * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TestActivity extends Activity {
    private static final String tag = "Rachel_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        normalSubscribe();
        subscribeAction();
        subscribeTransfromMap();

    }

    /**
     * Rxjava2和Rxjava1的区别：
     * ActionN 和 FuncN 遵循Java 8的命名规则。
     * 其中，Action0 改名成Action，Action1改名成Consumer，而Action2改名成了BiConsumer，而Action3 - Action9都不再使用了，ActionN变成了Consumer<Object[]> 。
     * 同样，Func改名成Function，Func2改名成BiFunction，Func3 - Func9 改名成 Function3 - Function9，FuncN 由 Function<Object[], R> 取代。
     * 01-10 15:48:49.917 4397-4397/? D/Rachel_test: onSubscribe
     * 01-10 15:48:49.917 4397-4397/? D/Rachel_test: onNextrachel
     * 01-10 15:48:49.917 4397-4397/? D/Rachel_test: onComplete
     */
    private void subscribeTransfromMap() {
        Log.d(tag, "------------------------------------subscribeTransfromMap-------------------------------------------------- ");
        Observable.just("rachel").map(new Function<String, Student>() {
            @Override
            public Student apply(String s) throws Exception {
                return new Student(s);
            }
        }).subscribe(new Observer<Student>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(tag, "onSubscribe");
            }

            @Override
            public void onNext(Student student) {
                Log.d(tag, "onNext"+student.getName());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d(tag, "onComplete");
            }
        });
    }

    /**
     01-10 15:48:49.916 4397-4397/? D/Rachel_test: 123
     01-10 15:48:49.916 4397-4397/? D/Rachel_test: 456
     01-10 15:48:49.916 4397-4397/? D/Rachel_test: 789
     */
    private void subscribeAction() {
        Log.d(tag, "------------------------------------subscribeAction-------------------------------------------------- ");
        Consumer<String> action = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(tag, s);
            }
        };
        String[] names = {"123", "456", "789"};
        Observable.fromArray(names)
                .subscribe(action);
    }

    /**
     01-10 15:48:49.915 4397-4397/? D/Rachel_test: onNextHello
     01-10 15:48:49.915 4397-4397/? D/Rachel_test: onNextHi
     01-10 15:48:49.915 4397-4397/? D/Rachel_test: onNextAloha
     01-10 15:48:49.915 4397-4397/? D/Rachel_test: onComplete
     */
    private void normalSubscribe() {
        Log.d(tag, "------------------------------------normalSubscribe-------------------------------------------------- ");

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onComplete() {
                Log.d(tag, "onComplete");
            }
            @Override
            public void onNext(Object o) {
                Log.d(tag, "onNext"+o);
            }

            @Override
            public void onError(Throwable e) {

            }


        };
        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext("Hello");
                emitter.onNext("Hi");
                emitter.onNext("Aloha");
                emitter.onComplete();
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
        Observable observable2 = Observable.fromArray(words);
// 将会依次调用：
// onNext("Hello");
// onNext("Hi");
// onNext("Aloha");
// onCompleted();
        observable.subscribe(observer);
    }
}
