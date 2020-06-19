package com.sd.demo.color_loading;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.demo.color_loading.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding mBinding;
    private final int[] mColors = new int[]{Color.parseColor("#D81B60"), Color.parseColor("#03DAC5"), Color.parseColor("#6200EE")};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.viewLoading.setColors(mColors);
        mBinding.viewLoading.start();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mBinding.viewLoading.stop();
    }
}