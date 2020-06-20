package com.sd.demo.color_loading;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.demo.color_loading.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.viewLoading.start();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mBinding.viewLoading.stop();
    }
}