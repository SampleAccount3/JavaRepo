package org.example;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args){
        APIRequestService apiRequestService = new APIRequestService();
        RetrofitService retrofitService = new RetrofitService();
        CompletableFutureDriver completableFutureDriver = new CompletableFutureDriver();

        Supplier<String> sample = ()-> "This is a Sample";

        APIComponent apiComponent = new APIComponent(apiRequestService, completableFutureDriver, retrofitService);
        CompletableFuture<List<HashMap<String, Object>>> omnibusApiService = apiComponent.getOmnibusData();

        omnibusApiService.thenApply(result -> result).exceptionally(ex->{
            System.err.println("Error: " + ex.getMessage());
            return null;
        }).join();
        CompletableFuture<List<HashMap<String, Object>>> omnibusApiService2 = apiComponent.getOmnibusData();
        omnibusApiService2.thenApply(result -> result).exceptionally(ex->{
            System.err.println("Error: " + ex.getMessage());
            return null;
        }).join();

        List<List<HashMap<String,Object>>> sampleJoin = List.of(omnibusApiService.join(),omnibusApiService2.join());

        sampleJoin.stream().forEach(System.out::println);
        Gson gson = new Gson();
        String json = gson.toJson(sampleJoin);
//        System.out.println(json);

        System.out.println("Finished");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CompletableFuture<String> sampleCompletable = CompletableFuture.supplyAsync(sample);

        try {
            System.out.println(sampleCompletable.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}