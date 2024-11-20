package org.example;


import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDriver {

    public CompletableFuture<String> getUserName(){
        return CompletableFuture.supplyAsync(()-> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return  "Sample UserName";
        });
    }

    public CompletableFuture<String> getUserAge(){
        return CompletableFuture.supplyAsync(()-> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return  "Sample Age 12";
        });
    }

    public CompletableFuture<List<HashMap<String, Object>>> getAPISamples() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // Simulate API delay
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Sample data
            HashMap<String, Object> sampleData1 = new HashMap<>();
            sampleData1.put("name", "John Doe");
            sampleData1.put("age", 30);

            HashMap<String, Object> sampleData2 = new HashMap<>();
            sampleData2.put("name", "Jane Doe");
            sampleData2.put("age", 25);

            return List.of(sampleData1, sampleData2); // Return list of HashMaps
        });
    }

    public CompletableFuture<HashMap<String, Object>> getAPIOmnibus(HashMap<String, Object> request) {
        return CompletableFuture.supplyAsync(() -> {
            HashMap<String, Object> PlaceHolderList = request;
            return PlaceHolderList; // Return list of HashMaps
        });
    }

    public CompletableFuture <HashMap<String, Object>> postAPIOmnibus(HashMap<String, Object> request) {
        return CompletableFuture.supplyAsync(() -> {
            HashMap<String, Object>  PlaceHolderList = request;
            return PlaceHolderList; // Return list of HashMaps
        });
    }
}
