package com.example.koranku;

import com.example.koranku.Model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterfaces {

    @GET("top-headlines")
    Call<News> getNews(
      @Query("country") String country,
      @Query("apiKey") String apiKey

    );



}
