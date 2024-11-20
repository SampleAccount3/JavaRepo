package org.example;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import javax.net.ssl.*;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RetrofitService {
    interface EndPoint{
        @GET("api/sales_mobility/coupon_sample/get_sample_data")
        Call<HashMap<String, Object>> getSampleVoucherCode();

        @POST("api/sales_mobility/coupon_sample/coupon_validity")
        Call <HashMap<String, Object>> getsampleVoucherValidity(
                @Query("coupon_code") String couponCode
        );

        @GET("https://jsonplaceholder.typicode.com/posts")
        Call<List<HashMap<String, Object>>> getSampleAPI();

    }

    public EndPoint getRft2(String baseURL) {
        HttpLoggingInterceptor httpLog = new HttpLoggingInterceptor();
        httpLog.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient unsafeClient = getUnsafeOkHttpClient()
                .newBuilder()
                .connectTimeout(60, TimeUnit.MINUTES)
                .readTimeout(60, TimeUnit.MINUTES)
                .writeTimeout(60, TimeUnit.MINUTES)
                .addInterceptor(httpLog)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(unsafeClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(EndPoint.class);
    }
    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };
            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create a ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
