package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ICallbackAble<String> sampleCallback = x -> x + "Sample";
        CallbackDriver<String> sample = new CallbackDriver<>(sampleCallback, "This is a Sample");
        System.out.println(sample.executeCallback());

        CompletableFutureDriver completableFutureDriver = new CompletableFutureDriver();

        CompletableFuture<String> getUserName = completableFutureDriver.getUserName();
        CompletableFuture<String> getAge = completableFutureDriver.getUserAge();

        CompletableFuture<String> combinedFuture = getUserName
                .thenCombine(getAge, (userName, age) -> {
                    System.out.println("User UserName: " + userName);
                    System.out.println("User Age: " + age);
                    return "Combined Result: " + userName + "&" + age;
                })
                .thenApplyAsync(combinedResult -> "Combined Result Processed: " + combinedResult)
                .exceptionally(error -> {
                    System.err.println("Error: " + error.getMessage());
                    return null;
                });
        System.out.println(combinedFuture.get() + "Done");
    }

}