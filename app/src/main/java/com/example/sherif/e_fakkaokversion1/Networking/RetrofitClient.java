package com.example.sherif.e_fakkaokversion1.Networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://192.168.1.13:81/e-fakaa_api/Exec/";
    private static   RetrofitClient instance;
    private Retrofit retrofit;

    public RetrofitClient()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance()
    {
        if(instance == null)
        {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Api getApi(){return  retrofit.create(Api.class);}

}
