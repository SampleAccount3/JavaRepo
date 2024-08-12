package org.example.Retrofit;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Map;

public interface APIService {
    @GET("/api/users/")
    Observable<Map<String,Object>> getData(
        @Query("page") String pageNumber
    );
}
