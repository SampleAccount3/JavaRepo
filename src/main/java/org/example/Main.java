package org.example;


import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
//        ObservableNObserver();
//        ObserverJust();
//        ObserverFromIterable();
//        ObserverRange();
//        ObserverInterval();
//        ObserverTimerObserver();
        ObserverAction();
//        SingleSingle();
//        MaybeMaybe();
        System.out.println("End");
//        System.out.println(ObserverAction());
        new Scanner(System.in).nextLine();
    }

    public static void MaybeMaybe(){
        Maybe<String> maybe = RxMaybe();

        maybe.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull String s) {
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Maybe Done");
            }
        });


    }

    private static Maybe<String> RxMaybe() {
        return Maybe.create(emitter -> {
            var newContent  = fetchUsers();
            if (newContent != null){
                emitter.onSuccess(newContent);
            }else{
                emitter.onComplete();
            }
        });
    }
    private static String fetchUsers(){
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    public static void SingleSingle(){
        RxSingle();
        Single<String> single = RxSingle();
        single.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull String s) {
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println(e);
            }
        });
    }

    private static Single<String> RxSingle() {
        return Single.create(Main::fetchUser);
    }

    private static void fetchUser(SingleEmitter<String> emitter) {
        new Thread(()->{
            try {
                Thread.sleep(5000);
                emitter.onSuccess("Melares");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    // Can be used in Async
    private static String ObserverAction() {
        AtomicReference<String> sample = new AtomicReference<>();
        Action action = () -> {
            System.out.println("Sleeping Start");
            new Thread(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Sleeping End");
            }).start();

        };

        Completable completable = Completable.fromAction(action);

        completable.subscribe(()->{
            System.out.println("Action Ends");
        });

        return "Success";
    }

    private static void ObserverTimerObserver() {
        Observable<Long> observable = Observable.timer(5,TimeUnit.SECONDS);
        observable.subscribe(message ->{
            System.out.println("5 secs has Passed");
        });
    }

    private static void ObserverInterval() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(System.out::println);
    }
    /**
        Assigns the arrayList to The Observers
     */
    public static void ObserverFromIterable(){
        ArrayList<Integer> lNumbers = new ArrayList<>();

        lNumbers.add(1);
        lNumbers.add(2);
        lNumbers.add(3);
        lNumbers.add(4);

        Observable<Integer> observable = Observable.fromIterable(lNumbers);

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };

        observable.subscribe(observer);
    }
    /**
    Assigns the non array element to the Observers
     */
    public static void ObserverJust(){
        Observable<String> observable = Observable.just("Item 1", "Item 2");

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error");
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };

        observable.subscribe(observer);
    }
    /**
     * Shortened Observable and Observer
     */
    public static void ObservableNObserver(){
        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("No.1");
            emitter.onNext("No.2");
            emitter.onNext("No.3");
//            emitter.onComplete();
            throw new Exception("Error");
        });

        //
        observable.subscribe(
                System.out::println,
                System.out::println,
                () -> {
                    System.out.println("Completed");
                }
        );

    }
    private static void ObserverRange() {
        Observable<Integer> observable = Observable.range(1,10);
        observable.subscribe(System.out::println);
    }
}