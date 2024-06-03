package org.example;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static java.lang.Thread.sleep;

/**
 * BackPressure Strategy:
 * Missing - no BackPressure Strategy
 * Error - downStream throws an exception right away when it cannot keep up with the source
 * Buffer - items are buffered until downstream is able to handle it
 * Latest - last emission is kept until downstream is able to handle it
 * Drop - when downstream cannot handle new emissions, all of these emissions are discarded
 *
 * can be applied using Flowable.create(source, strategy)
 * can be applied using onBackpressureX (X - Missing, Drop etc.)
 */
public class Main {
    public static void main(String[] args) {
//        synchronousObservableExample();
//        asynchronousObservableExample();
        asyncFlowableExample();
    }

    private static void asyncFlowableExample() {
        Flowable.range(1,2048)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe( item -> {
                    sleep(100);
                    System.out.println("Received my Item: " + item.id + "\n");
                        });
        try {
            sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void synchronousObservableExample(){
         Observable.range(1,10000)
                 .map(Item::new)
                 .subscribe(item -> {
                     sleep(1000);
                     System.out.println("Received my Item" + item.id + "\n");
                 });

     }

     public static void asynchronousObservableExample(){
        Observable.range(1,10)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe(item ->{
                    sleep(1000);
                    System.out.println("Received MyItem: " + item.id + "\n");
                });
         try {
             sleep(Long.MAX_VALUE);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }
}

class Item{
    int id;
    public Item(int id){
        this.id = id;
        System.out.println("Item is Created: " + id);
    }
}