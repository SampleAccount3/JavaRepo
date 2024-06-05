package org.example;

import io.reactivex.rxjava3.core.Observable;

public class Main {

    public static void main(String[] args) {
//        rxMap();
//        rxSorted();
//        rxScan();
//        rxBuffer();
//        rxGroupBy();
//        rxFlatMap();
//        rxToList();
//        rxMergeWith();
        rxZipWith();
    }

    private static void rxZipWith() {
        var obs1 = Observable.just("A","B");
        var obs2 = Observable.just("C","D");

        obs1.zipWith(obs2,(item1,item2) ->{
            return String.format("%s%s",item1,item2);
        }).subscribe(System.out::println);

    }

    private static void rxMergeWith() {
        Observable.just(1,2,3)
                .mergeWith(Observable.just(4,5))
                .subscribe(System.out::println);
    }

    private static void rxToList() {
        Observable.just(1,2,3)
                .toList()
                .subscribe(System.out::println);
    }

    private static void rxFlatMap() {
        Observable.just(1,2,3)
                .flatMap(item -> Observable.just(item * 2))
                .subscribe(item -> System.out.println(item));
    }

    private static void rxGroupBy() {
        Observable.just("ccc","a","a","bb","bb","bb","bb","ccc","ccc","ccc")
                .groupBy(item -> item.length())
                .flatMapSingle(Observable::toList)
                .subscribe(System.out::println);
    }

    private static void rxBuffer() {
        Observable.range(1,10)
                .buffer(2)
                .subscribe(System.out::println);
    }

    private static void rxScan() {
        Observable.just(1,2,3)
                .scan(Integer::sum)
                .subscribe(System.out::println);
    }

    private static void rxSorted() {
        Observable.just(1,2,3)
                .sorted()
                .subscribe(System.out::println);
    }

    private static void rxMap() {
        Observable.just(3,1,2)
                .map(String::valueOf)
                .subscribe(System.out::println);
    }


}