package cn.hellovpn.wechatter;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import cn.hellovpn.wechatter.databinding.ActivityScanResultBinding;
import cn.hellovpn.wechatter.databinding.ActivitySelfCheckBinding;

public class ScanResultActivity extends AppCompatActivity {

   // private AppBarConfiguration appBarConfiguration;
    private ActivityScanResultBinding binding;
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
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }

        binding = ActivityScanResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        TextView tvDate=findViewById(R.id.tvDate);
//        SimpleDateFormat sdfDate = new SimpleDateFormat(
//                "yyyy-MM-dd");
//        tvDate.setText(sdfDate.format(new Date()));

        TextView myText = (TextView) findViewById(R.id.tvNormal );

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(400); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);

    }

}