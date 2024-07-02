package org.example;

import java.util.concurrent.CompletableFuture;

public class AsyncClass {
    public void asyncFunction(int x, int y, Callback2 callback2){
        CompletableFuture.supplyAsync(()->{
            // Simulate some work with a delay
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return x + y;
        }).thenAccept(result ->{
            // Pass the result and additional data to the callback
            callback2.onComplete(result, "Calculation Completed");
        });
    }
}
