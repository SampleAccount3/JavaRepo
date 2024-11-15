package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try {
            // Start both asynchronous tasks
            CompletableFuture<String> userDetailsFuture = getUserDetailsAsync();
            CompletableFuture<String> userOrdersFuture = getUserOrdersAsync();

            // Combine results when both tasks complete
            CompletableFuture<Void> combinedFuture = userDetailsFuture
                    .thenCombine(userOrdersFuture, (userDetails, userOrders) -> {
                        System.out.println("User Details: " + userDetails);
                        System.out.println("User Orders: " + userOrders);
                        return "Combined Result";
                    })
                    .thenAccept(combinedResult -> System.out.println("Combined Result Processed: " + combinedResult))
                    .exceptionally(error -> {
                        System.err.println("Error: " + error.getMessage());
                        return null;
                    });

            // Wait for all tasks to complete
            combinedFuture.get();

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // Simulate an asynchronous task to get user details
    private static CompletableFuture<String> getUserDetailsAsync() {
        return CompletableFuture.supplyAsync(() -> {
            delay(); // Simulate network delay
            System.out.println("Fetching user details...");
            return "John Doe";
        });
    }

    // Simulate an asynchronous task to get user orders
    private static CompletableFuture<String> getUserOrdersAsync() {
        return CompletableFuture.supplyAsync(() -> {
            delay(); // Simulate network delay
            System.out.println("Fetching user orders...");
            return "Order#12345";
        });
    }

    // Helper method to simulate delay
    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
