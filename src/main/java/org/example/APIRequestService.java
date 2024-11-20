package org.example;

import com.google.gson.internal.LinkedTreeMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APIRequestService {
    final String baseUrl = "http://127.0.0.1:8000/";
    private String[] params;

    public APIRequestService(String... params) {
        this.params = params;
    }

    public APIRequestService() {
    }

    public HashMap<String, Object> getVoucherCOde(RetrofitService retrofitService) {
        Call<HashMap<String, Object>> call = retrofitService.getRft2(baseUrl).getSampleVoucherCode();
        HashMap<String, Object> items = null;
        try {
            Response<HashMap<String, Object>> response = call.execute(); // Execute synchronously
            if (response.isSuccessful() && response.body() != null) {
                HashMap<String, Object> responseBody = response.body();
                // Cast "items" to a List of HashMaps
                items = (HashMap<String, Object>) responseBody;

//                System.out.println(items);
            } else {
                System.out.println("Response was not successful or response body is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        return items;
    }

//    public HashMap<String, Object>ValidateVoucher(RetrofitService retrofitService){
//        final String couponCode = this.params[0];
//        Call<List< HashMap<String, Object>>> call = retrofitService.getRft2(baseUrl).getsampleVoucherValidity(couponCode);
//        HashMap<String, Object> items = null;
//        try {
//            Response <List< HashMap<String, Object>>> response = call.execute();
//            if (response.isSuccessful() && response.body() != null) {
//                List< HashMap<String, Object>> responseBody = response.body();
//                // Cast "items" to a List of HashMaps
//                items = (HashMap<String, Object>) responseBody.get(0);
//                if (items != null) {
//                }
//            } else {
//                System.out.println("Response was not successful or response body is null.");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return items;
//    }
//    public List<HashMap<String, Object>>ValidateVoucher(RetrofitService retrofitService){
//
//        final String couponCode = this.params[0];
//            Call<List<HashMap<String, Object>>> call = retrofitService.getRft2(baseUrl).getsampleVoucherValidity(couponCode);
//            List<HashMap<String, Object>> items = null;
//
//        try {
//            Response <List< HashMap<String, Object>>> response = call.execute();
//            if (response.isSuccessful() && response.body() != null) {
//                List< HashMap<String, Object>> responseBody = response.body();
//                // Cast "items" to a List of HashMaps
//                items = responseBody; // This contains the entire list of HashMaps
//
//                if (items != null) {
//                }
//            } else {
//                System.out.println("Response was not successful or response body is null.");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//            return items;
//    }

    public HashMap<String, Object> ValidateVoucher(RetrofitService retrofitService) {

        final String couponCode = this.params[0];
        Call<HashMap<String, Object>> call = retrofitService.getRft2(baseUrl).getsampleVoucherValidity(couponCode);
        HashMap<String, Object> items = null;

        try {
            Response<HashMap<String, Object>> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                // Assign the full list to "items"
                items = response.body();
            } else {
                System.out.println("Response was not successful or response body is null.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return items;
    }


}
