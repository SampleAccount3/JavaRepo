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
//        asyncCallbackFunction();
//        try {
//            completableFutureFunction();
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        AsyncClass asyncClass =  new AsyncClass();

        asyncClass.asyncFunction(2,1,((result, message) -> {
            System.out.println(message + " : " + result);
        }));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void completableFutureFunction() throws ExecutionException, InterruptedException {
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Future Thread: " + Thread.currentThread().getName();
        });
        System.out.println(future.get());
    }


    private static void asyncCallbackFunction() {
        AsyncCallback asyncCallback = new AsyncCallback();
        Runnable runnable = () -> System.out.println("Callback Executed");
        asyncCallback.performAsyncCallback(runnable);
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
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int x = 2, y = 5, z = 0;
        z = x + y;
        // Work is done, call the callback
        callback.onComplete(z);
    }
}