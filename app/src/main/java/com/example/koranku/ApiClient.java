package com.example.koranku;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public  static final String BASE_URL ="http://newsapi.org/v2/";
    public static ApiClient apiClient;
    public static Retrofit retrofit;

   private ApiClient(){
       retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

   }

   public static synchronized  ApiClient getInstance(){
       if (apiClient ==null){
           apiClient = new ApiClient();
       }

       return  apiClient;
   }

    public ApiInterfaces getApi(){
       return  retrofit.create(ApiInterfaces.class);
    }
}

