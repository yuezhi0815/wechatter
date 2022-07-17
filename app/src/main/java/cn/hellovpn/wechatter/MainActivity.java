package cn.hellovpn.wechatter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import cn.hellovpn.wechatter.databinding.ActivityMainBinding;
import cn.hellovpn.wechatter.fragments.FragmentViewPagerActivity;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnViewsDemo.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ViewsSliderActivity.class));
        });

        binding.btnFragmentDemo.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, FragmentViewPagerActivity.class));
        });
    }
}