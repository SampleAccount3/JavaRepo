package org.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        coldObserverSample();
        hotObserverSample();
    }

    /** for each observable continue receiving the items
     *
     * @throws InterruptedException
     */
    private static void hotObserverSample() throws InterruptedException {
        ConnectableObservable observable = Observable.interval(1, TimeUnit.SECONDS)
                .publish();

        observable.connect();

        observable.subscribe((item) -> {
            System.out.println("Observer 1, sec: " + item);
        });
        Thread.sleep(5000);
        observable.subscribe((item) -> {
            System.out.println("Observer 2, sec: " + item);
        });
        Thread.sleep(5000);
    }

    /** for each subscriber it emits the same items
     *
     */
    private static void coldObserverSample() {
        Observable<String> observable = Observable.just("a","b","c");

        observable.subscribe(item-> System.out.println("Observer 1 " + item));
        observable.subscribe(item-> System.out.println("Observer 2 " + item));
        observable.subscribe(item-> System.out.println("Observer 3 " + item));
    }

}