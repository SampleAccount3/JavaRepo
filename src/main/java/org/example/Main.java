package org.example;

import io.reactivex.rxjava3.core.Observable;

public class Main {

    public static void main(String[] args) {
//        Filter Operators

//        rxFilter();
//        rxTake();
//        rxSkip();
//        rxDistinct();
//        rxFirst();
//        rxLast();

//        Conditional Operators

//        rxTakeWhile();
//        rxSkipWhile();
//        rxAll();
//        rxAny();
//        rxDefault();
//        rxSwitchWhenEmpty();
    }

    private static void rxSwitchWhenEmpty() {
        Observable.just(1,2,3,4,5)
                .takeWhile(item -> item > 5)
                .switchIfEmpty(Observable.just(5,4,3,2,1))
                .subscribe(System.out::println);
    }

    private static void rxDefault() {
        Observable.just(1,2,3,4,5)
                .takeWhile(item -> item > 5)
                .defaultIfEmpty(0)
                .subscribe(System.out::println);
    }

    private static void rxAny() {
        Observable.just("Jan","Feb","Mar")
                .any(item -> item.length() > 4)
                .subscribe(System.out::println);
    }

    private static void rxAll() {
        Observable.just("Jan","Feb","Mar")
                .all(item -> item.length() <= 4)
                .subscribe(System.out::println);
    }

    private static void rxSkipWhile() {
        Observable.just(1,2,3,4,5)
                .skipWhile(item -> item <= 4)
                .subscribe(System.out::println);
    }

    private static void rxTakeWhile() {
        Observable.just(1,2,3,4,5)
                .takeWhile(item -> item <=3)
                .subscribe(System.out::println);
    }

    private static void rxLast() {
        Observable.just("Hello", "my", "World","HAHA")
                .last("")
                .subscribe(item -> System.out.println(item));
    }

    private static void rxFirst() {
        Observable.just("Hello", "my", "World","Hello")
                .first("")
                .subscribe(item -> System.out.println(item));
    }

    private static void rxDistinct() {
        Observable.just("Hello", "my", "World","Hello")
                .distinct()
                .subscribe(item -> System.out.println(item));
    }

    private static void rxSkip() {
        Observable.just("Hello", "my", "World")
                .skip(2)
                .subscribe(item -> System.out.println(item));
    }

    private static void rxTake() {
        Observable.just("Hello", "my", "World")
                .take(2)
                .subscribe(item->{
                    System.out.println("2 Items: " + item);
                });
    }

    private static void rxFilter() {
        Observable.just("Sample", "sa" , "RxJava")
                .filter(item -> item.length() ==2)
                .subscribe(System.out::println);
    }


}