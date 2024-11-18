package org.example;

import com.google.gson.internal.LinkedTreeMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.List;

public class APIRequestService {
    final String baseUrl = "http://127.0.0.1:8000/";

    public List<HashMap<String, Object>> getVoucherCOde(RetrofitService retrofitService) {
        Call<HashMap<String, Object>> call = retrofitService.getRft2(baseUrl).getSampleVoucherCode();
        List<?> items = null;
//        call.enqueue(new Callback<HashMap<String, Object>>() {
//            @Override
//            public void onResponse(Call<HashMap<String, Object>> call, Response<HashMap<String, Object>> response) {
//                if (response.body() != null) {
//                    HashMap<String, Object> responseBody = response.body();
//                    System.out.println("Brand: " + responseBody.get("brand"));
//                    System.out.println("Brand: " + responseBody.get("items"));
//                    // Cast "items" to a List of HashMaps
//                    List<?> items = (List<HashMap<String, Object>>) responseBody.get("items");
//                    if (items != null) {
//                        for (Object item : items) {
//                            LinkedTreeMap<?, ?> map = (LinkedTreeMap<?, ?>) item;
//                            System.out.println("Barcode: " + map.get("barcode"));
//                            System.out.println("Description: " + map.get("description"));
//                            System.out.println("Discount: " + map.get("discount"));
//                        }
//                    }
//                } else {
//                    System.out.println("Response body is null.");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<HashMap<String, Object>> call, Throwable throwable) {
//
//            }
//        });

        try {
            // Synchronous call using execute()
//            Call<HashMap<String, Object>> call = retrofitService.getRft2(baseUrl).getSampleVoucherCode();
            Response<HashMap<String, Object>> response = call.execute(); // Execute synchronously

            if (response.isSuccessful() && response.body() != null) {
                HashMap<String, Object> responseBody = response.body();
//                System.out.println("Brand: " + responseBody.get("brand"));
//                System.out.println("Items: " + responseBody.get("items"));

                // Cast "items" to a List of HashMaps
                items = (List<HashMap<String, Object>>) responseBody.get("items");
                if (items != null) {
                    for (Object item : items) {
                        LinkedTreeMap<?, ?> map = (LinkedTreeMap<?, ?>) item;
//                        System.out.println("Barcode: " + map.get("barcode"));
//                        System.out.println("Description: " + map.get("description"));
//                        System.out.println("Discount: " + map.get("discount"));
                    }
                }
            } else {
                System.out.println("Response was not successful or response body is null.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }

        return (List<HashMap<String, Object>>) items;
    }
}
