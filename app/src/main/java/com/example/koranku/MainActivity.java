package com.example.koranku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.koranku.Model.Articles;
import com.example.koranku.Model.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    final String API_KEY = "51c2fae0aa354e8a91c8ef981a395e92";
    Adapter adapter;
    List<Articles> articles = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String country = getCountry();
        loadJson(country, API_KEY);
    }

    public void loadJson(String country, String apiKey){

        Call<News> call = ApiClient.getInstance().getApi().getNews(country, apiKey);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful() && response.body().getArticles() != null){

                        articles.clear();
                        articles = response.body().getArticles();
                        adapter = new Adapter(MainActivity.this,articles);
                        recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();



            }
        });





    }

    public  String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();


    }
}