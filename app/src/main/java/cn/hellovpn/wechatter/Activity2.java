package cn.hellovpn.wechatter;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.r0adkll.slidr.model.SlidrPosition;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    private SlidrInterface slidr;
    private SlidrConfig mConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mConfig = new SlidrConfig.Builder()
             //   .primaryColor(primary)
             //   .secondaryColor(secondary)
                .position(SlidrPosition.VERTICAL)
                .velocityThreshold(2400)
//                .distanceThreshold(.25f)
//                .edge(true)
              //  .touchSize(SizeUtils.dpToPx(this, 32))
                .build();

        slidr = Slidr.attach(this, mConfig);
    }

    public void lockSlide(View v) {
        slidr.lock();
    }

    public void unlockSlide(View v) {
        slidr.unlock();
    }
}