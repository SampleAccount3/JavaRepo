package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Main {

    public static void main(String[] args) {
//        callbackFunction();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        while(true){
            executor.execute(new Runnable() {
                public void run() {
                    System.out.println("Asynchronous task");
                }
            });
            executor.shutdown();
        }




//        Callable<Integer> task = () -> {
//            TimeUnit.SECONDS.sleep(5);
//            return 123;
//        };
//
//        ExecutorService executor2 = Executors.newFixedThreadPool(2);
//        Future<Integer> future = executor2.submit(task);
//
//        System.out.println("Future done? " + future.isDone());
//
//        Integer result = null;  // Waits for the task to complete and retrieves the result
//        try {
//            result = future.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("Future done? " + future.isDone());
//        System.out.println("Result: " + result);
//
//        executor2.shutdown();
    }

    private static void callbackFunction() {
        Executor executor = new Executor( (x) ->{
            System.out.println("This is my Message: " + x );
        });
        System.out.println("1");
        executor.doWork();
        System.out.println("2");
    }


}

interface Callback{
    void onComplete(int x);
}

class Executor{
    private Callback callback;
    public Executor(Callback callback) {
        this.callback = callback;
    }
    public void doWork(){
        // Simulate some work with a thread sleep
        try {
            System.out.println("Working...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int x = 2, y = 5, z = 0;
        z = x + y;
        // Work is done, call the callback
        callback.onComplete(z);
    }
}