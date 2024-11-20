package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class APIComponent {

    APIRequestService apiRequestService;
    CompletableFutureDriver completableFutureDriver;
    RetrofitService retrofitService;

    public APIComponent(APIRequestService apiRequestService, CompletableFutureDriver completableFutureDriver, RetrofitService retrofitService) {
        this.apiRequestService = apiRequestService;
        this.completableFutureDriver = completableFutureDriver;
        this.retrofitService = retrofitService;
    }

    public APIComponent(APIRequestService apiRequestService, CompletableFutureDriver completableFutureDriver) {
        this.apiRequestService = apiRequestService;
        this.completableFutureDriver = completableFutureDriver;
    }

    public APIComponent(APIRequestService apiRequestService) {
        this.apiRequestService = apiRequestService;
    }

    public APIComponent() {
    }

    public CompletableFuture<HashMap<String, Object>> getOmnibusData(){
//        System.out.println(completableFutureDriver.getAPIOmnibus(apiRequestService.getVoucherCOde(this.retrofitService)));
        return completableFutureDriver.getAPIOmnibus(apiRequestService.getVoucherCOde(this.retrofitService));
    }
    public CompletableFuture<HashMap<String, Object>> postOmnibusData(){
//        System.out.println(completableFutureDriver.getAPIOmnibus(apiRequestService.getVoucherCOde(this.retrofitService)));
        return completableFutureDriver.postAPIOmnibus(apiRequestService.ValidateVoucher(this.retrofitService));
    }
}
