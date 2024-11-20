package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        APIRequestService apiRequestService = new APIRequestService();
        APIRequestService postAPIRequestService = new APIRequestService("027700000307");
        RetrofitService retrofitService = new RetrofitService();
        CompletableFutureDriver completableFutureDriver = new CompletableFutureDriver();

        APIComponent apiComponent = new APIComponent(apiRequestService, completableFutureDriver, retrofitService);

        APIComponent voucherValidity = new APIComponent(postAPIRequestService,completableFutureDriver, retrofitService);
        CompletableFuture<HashMap<String, Object>> omnibusApiService = apiComponent.getOmnibusData();

        omnibusApiService.thenApply(result -> result).exceptionally(ex->{
            System.err.println("Error: " + ex.getMessage());
            return null;
        }).join();
        CompletableFuture<HashMap<String, Object>> omnibusApiService2 = voucherValidity.postOmnibusData();

        omnibusApiService2.thenApply(result -> result).exceptionally(ex->{
            System.err.println("Error: " + ex.getMessage());
            return null;
        }).join();

//        Object result = omnibusApiService.join();
//        System.out.println(result.getClass().getName());
//        System.out.println(result);


//        List<List<HashMap<String,Object>>> sampleJoin = List.of(omnibusApiService.join(),(List<HashMap<String, Object>>)omnibusApiService2.join());

        List<Object> sampleJoin = List.of(
                omnibusApiService.join(),
                omnibusApiService2.join()
        );

        sampleJoin.forEach(System.out::println);
    }

    private static void sampleSupplyAsync() {
        Supplier<String> sample = ()-> "This is a Sample";
        CompletableFuture<String> sampleCompletable = CompletableFuture.supplyAsync(sample);

        try {
            System.out.println(sampleCompletable.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}