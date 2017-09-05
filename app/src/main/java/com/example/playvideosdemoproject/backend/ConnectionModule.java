package com.example.playvideosdemoproject.backend;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sarabjjeet on 9/5/17.
 */

public class ConnectionModule {

    private static final String ROOT_URL = " http://192.168.3.31/mindfulness/api/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …

// add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiInterface getApiService() {
        return getRetrofitInstance().create(ApiInterface.class);
    }
}
