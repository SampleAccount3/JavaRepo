package org.example;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        APIRequestService apiRequestService = new APIRequestService();
        RetrofitService retrofitService = new RetrofitService();
        CompletableFutureDriver completableFutureDriver = new CompletableFutureDriver();

        APIComponent apiComponent = new APIComponent(apiRequestService,completableFutureDriver,retrofitService);

        ICallbackAble<String> sampleCallback = x -> x + "Sample";
        CallbackDriver<String> sample = new CallbackDriver<>(sampleCallback, "This is a Sample");
//        System.out.println(sample.executeCallback());

        CompletableFuture<String> getUserName = completableFutureDriver.getUserName();
        CompletableFuture<String> getAge = completableFutureDriver.getUserAge();
        CompletableFuture<List<HashMap<String, Object>>> getAPISamples = completableFutureDriver.getAPISamples();

        CompletableFuture<List<HashMap<String, Object>>> omnibusApiService = apiComponent.getOmnibusData();

        omnibusApiService.thenApply(result ->{
//            System.out.println("API Call result" + result);
            return result;
        }).exceptionally(ex->{
            System.err.println("Error: " + ex.getMessage());
            return null;
        }).join();
        CompletableFuture<List<HashMap<String, Object>>> omnibusApiService2 = apiComponent.getOmnibusData();

        omnibusApiService2.thenApply(result ->{
//            System.out.println("API Call result" + result);
            return result;
        }).exceptionally(ex->{
            System.err.println("Error: " + ex.getMessage());
            return null;
        }).join();

        List<List<HashMap<String,Object>>> sampleJoin = List.of(omnibusApiService.join(),omnibusApiService2.join());
//        System.out.println(sampleJoin);

        Gson gson = new Gson();
        String json = gson.toJson(sampleJoin);
        System.out.println(json);
//        System.out.println(omnibusApiService.join()+": Sample");
//        System.out.println(omnibusApiService2.join()+": Sample2");
//        CompletableFuture<String> combinedFuture = getUserName
//                .thenCombine(getAge, (userName, age) -> {
//                    System.out.println("User UserName: " + userName);
//                    System.out.println("User Age: " + age);
//                    return "Combined Result: " + userName + "&" + age;
//                })
//                .thenCombineAsync(getAPISamples, (combinedResult, apiSamples) -> {
//                    System.out.println("Combined Result: " + combinedResult);
//                    System.out.println("API Samples:");
//                    for (HashMap<String, Object> sampleHash : apiSamples) {
//                        System.out.println(sampleHash);
//                    }
//                    return "Final Result: " + combinedResult + " with " + apiSamples.size() + " API samples.";
//                })
//                .thenCombineAsync(apiComponent.getOmnibusData(),(omnibusData,apiSamples) -> omnibusData)
//                .exceptionally(error -> {
//                    System.err.println("Error: " + error.getMessage());
//                    return null;
//                });
//        System.out.println(combinedFuture.get() + "Done");

        Thread.sleep(1000);
    }

}