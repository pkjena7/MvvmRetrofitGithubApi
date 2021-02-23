package com.example.mvvmretrofitgithubapi.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {


    private static String BASE_URL = "https://api.github.com/";

    public static OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();


    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S cteateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }


    public static Retrofit getRetrofitClient() {
        return retrofit;
    }





}
