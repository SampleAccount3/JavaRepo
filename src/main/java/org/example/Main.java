package org.example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        final String baseURL = "http://127.0.0.1:8000/";
//        final String baseURL = "http://10.10.111.242:8000";

//       getDataSample(baseURL);
        postDataSample(baseURL);
        String name = "value";
    }

    private static void postDataSample(String baseURL) {
        Call<List<HashMap<String, Object>>> call = new RetrofitService().getRft2(baseURL).getsampleVoucherValidity("123456789103");
        call.enqueue(new Callback<List<HashMap<String, Object>>>() {
            @Override
            public void onResponse(Call<List<HashMap<String, Object>>> call, Response<List<HashMap<String, Object>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Print the "data" key value
                    HashMap<String, Object> item = response.body().get(0); // Access the first item
                    System.out.println(item.get("item"));
//                    System.out.println(response.body().get(0);
//                    System.out.println(response.body().get("items"));

                } else {
                    System.out.println("Response body is null or not successful: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<HashMap<String, Object>>> call, Throwable throwable) {

            }
        });
//        Call<HashMap<String, Object>> call = new RetrofitService().getRft2(baseURL).getsampleVoucherValidity("123456789102");
//        call.enqueue(new Callback<HashMap<String, Object>>() {
//            @Override
//            public void onResponse(Call<HashMap<String, Object>> call, Response<HashMap<String, Object>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    // Print the "data" key value
//                    HashMap<String, Object> item = response.body().get(0); // Access the first item
//                    System.out.println(item.get("item"));
////                    System.out.println(response.body().get(0);
////                    System.out.println(response.body().get("items"));
//
//                } else {
//                    System.out.println("Response body is null or not successful: " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<HashMap<String, Object>> call, Throwable throwable) {
//                throwable.printStackTrace();
//                System.out.println("Request failed: " + throwable.getMessage());
//            }
//        });
    }

    private static void getDataSample(String baseURL) {
        // Correct the generic type usage here
        Call<HashMap<String, Object>> call = new RetrofitService().getRft2(baseURL).getSampleVoucherCode();
        call.enqueue(new Callback<HashMap<String, Object>>() {
            @Override
            public void onResponse(Call<HashMap<String, Object>> call, Response<HashMap<String, Object>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    // Print the "data" key value
                    System.out.println(response.body().get("brand"));
                    System.out.println(response.body().get("items"));
                } else {
                    System.out.println("Response body is null or not successful: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<HashMap<String, Object>> call, Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("Request failed: " + throwable.getMessage());
            }
        });
    }
}
