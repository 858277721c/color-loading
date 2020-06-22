package com.sd.demo.color_loading;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.lib.cloading.view.FLinearColorLoadingView;

public class MainActivity extends AppCompatActivity
{
    private FLinearColorLoadingView view_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_loading = findViewById(R.id.view_loading);

        view_loading.start();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        view_loading.stop();
    }
}