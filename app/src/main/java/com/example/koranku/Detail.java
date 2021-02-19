package com.example.koranku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {

    TextView tvTitle, tvSource, tvDate, tvDesc;
    ImageView imageView;
    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        tvTitle = findViewById(R.id.tvTitle);
        tvSource = findViewById(R.id.tvSource);
        tvDate = findViewById(R.id.tvDate);
        tvDesc = findViewById(R.id.tvDesc);

        imageView = findViewById(R.id.imageDetail);
        progressBar = findViewById(R.id.loaderDetail);

        progressBar.setVisibility(View.VISIBLE);

        webView = findViewById(R.id.webView);

        Intent intent = getIntent();
        //ambil semua data dari class Adapter
        String title = intent.getStringExtra("title");
        String source = intent.getStringExtra("source");
        String time = intent.getStringExtra("time");
        String desc = intent.getStringExtra("desc");
        String imageurl = intent.getStringExtra("imageUrl");
        String url = intent.getStringExtra("url");

        tvTitle.setText(title);
        tvSource.setText(source);
        tvDate.setText(time);
        tvDesc.setText(desc);

        Picasso.with(Detail.this).load(imageurl).into(imageView);

        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        if (webView.isShown()){
            progressBar.setVisibility(View.INVISIBLE);
        }


    }
}