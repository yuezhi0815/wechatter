package cn.hellovpn.wechatter;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import cn.hellovpn.wechatter.databinding.ActivityHealthListBinding;
import cn.hellovpn.wechatter.databinding.ActivitySelfCheckBinding;

public class SelfCheckActivity extends AppCompatActivity {

   // private AppBarConfiguration appBarConfiguration;
    private ActivitySelfCheckBinding binding;
    private ImageView ivGif;
private AnimationDrawable rocketAnimation;

    @Override
    protected void onStart() {
        super.onStart();
       // rocketAnimation.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySelfCheckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView tvDate=findViewById(R.id.tvDate);
        SimpleDateFormat sdfDate = new SimpleDateFormat(
                "yyyy年MM月dd日");
        tvDate.setText(sdfDate.format(new Date()));

    //        TextView tvTime=findViewById(R.id.tvTime);
    //        SimpleDateFormat sdfTime = new SimpleDateFormat(
    //                "HH:mm:ss");
    //        tvTime.setText(sdfTime.format(new Date()));

        TextView tvQuery=findViewById(R.id.tvQuery);
        SimpleDateFormat sdfQuery = new SimpleDateFormat(
                "MM-dd ");
        tvQuery.setText(sdfQuery.format(new Date())+"07:55");


        TextView tvExpire=findViewById(R.id.tvExpire);

        tvExpire.setText(sdfQuery.format(new Date())+"24:00");




    }

}