package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//       completableFutures();
//       composeSample();
//       streamComputation();

        multipleFutureAllOf();
    }

    private static void multipleFutureAllOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future 1 Done");
            return "Hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future 2 Done");
            return "World ";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future 3 Done");
            return "!! ";
        });

        // can be used in Computation that Includes the database
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
        combinedFuture.get();

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println(combined);
    }

    private static void completableFutures() throws ExecutionException, InterruptedException {
        Future<String> completableFuture = calculateAsync();
        Future<String> completableFuture2 = calculateAsync2();
        String result = completableFuture.get();
        String result2 = completableFuture2.get();
//        System.out.println(result);
//        System.out.println(result2);
        CompletableFuture<String> sample = null;
//    Processing Async Operations
        CompletableFuture<String> asyncOperations = CompletableFuture.supplyAsync(()->"Hello ");
        CompletableFuture<String> futureasyncOperations = asyncOperations
                //Supplier
                .thenApply(s -> s + "World");
        CompletableFuture<String> futureasyncOperations2 = futureasyncOperations
                //Supplier
                .thenApply(s -> s + "!!!");
        //Consumer
//              .thenAccept

    }

    private static void composeSample() throws ExecutionException, InterruptedException {
        // Combining Completable Future with Compose
        CompletableFuture<Integer> compose = CompletableFuture
                .supplyAsync(() -> 2)
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> {
                    System.out.println("Task 1 Completed");
                    return s + 3;
                }))
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> {
                    System.out.println("Task 2 Completed");
                    return s + 4;
                }))
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> {
                    System.out.println("Task 3 Completed");
                    return s + 5;
                }));

        System.out.println(compose.get());
    }

    private static void streamComputation() {
        Map<String, Double> products = new HashMap<>();
        products.put("Laptop", 1500.00);
        products.put("Headphones", 50.00);
        products.put("Smartphone", 800.00);
        products.put("Keyboard", 120.00);

        double discountRate = 0.10; // 10% discount
        System.out.println(products.entrySet());

        // Apply discount using Streams
        Map<String, Double> discountedProducts = products.entrySet().stream()
                .map(entry -> {
                    // Apply discount if the price is greater than 100
                    if (entry.getValue() > 100) {
                        double discountedPrice = entry.getValue() * (1 - discountRate);
                        return Map.entry(entry.getKey(), discountedPrice);
                    } else {
                        return entry; // No discount for products under $100
                    }
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        discountedProducts.forEach((name, price) -> System.out.println(name + ": " + price));
    }

    // Using a Completable future as simple future
    public static Future<String> calculateAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            completableFuture.complete("Hello1");
            return null;
        });
        return completableFuture;
    }

    public static Future<String> calculateAsync2() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            completableFuture.complete("Hello2");
            return null;
        });
        return completableFuture;
    }



}