package cn.hellovpn.wechatter;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import cn.hellovpn.wechatter.Activity2;
import cn.hellovpn.wechatter.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void openActivity2(View v) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}