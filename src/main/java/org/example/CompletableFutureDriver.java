package org.example;

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
}
