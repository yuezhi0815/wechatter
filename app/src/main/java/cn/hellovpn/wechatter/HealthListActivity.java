package cn.hellovpn.wechatter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.skateboard.zxinglib.CaptureActivity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import cn.hellovpn.wechatter.databinding.ActivityHealthListBinding;


public class HealthListActivity extends AppCompatActivity {

   // private AppBarConfiguration appBarConfiguration;
    private ActivityHealthListBinding binding;
    private TextView tvSelfCheck, tvScan, tvWithoutScan;
    private static final int pic_id = 123;
    ActivityResultLauncher<Intent> someActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHealthListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.tvSelfCheck = binding.tvSelfCheck;
        this.tvScan = binding.tvScan;
        this.tvWithoutScan = binding.tvWithoutScan;


        this.tvSelfCheck.setOnClickListener( view -> {

//            Toast.makeText(view.getContext(), "SelfCheck Clicked. ", Toast.LENGTH_SHORT).show();
//

                startActivity(new Intent(view.getContext(),
                        SelfCheckActivity.class));
                }

        );
        this.tvScan.setOnClickListener( view -> {

//            startActivity(new Intent(view.getContext(),
//                    ScanResultActivity.class));
//                    Intent intent = new Intent(view.getContext(), CaptureActivity.class);
//                    startActivityForResult(intent, 1001);

                    Intent intent = new Intent(this, CaptureActivity.class);
                    someActivityResultLauncher.launch(intent);


                }

        );

        this.tvWithoutScan.setOnClickListener( view -> {

            startActivity(new Intent(view.getContext(),
                    ScanResultActivity.class));

                }

        );

        // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
         someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // There are no request codes
                            Intent data = result.getData();
                            startActivity(new Intent(HealthListActivity.this, ScanResultActivity.class));

                        }
                    }
                });

    }



//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1001 && resultCode == Activity.RESULT_OK) {
////            String result = data.getStringExtra(CaptureActivity.KEY_DATA);
////            Toast.makeText(this, "qrcode result is " + result, Toast.LENGTH_SHORT).show();
//
//            startActivity(new Intent(HealthListActivity.getContext(),
//                    ScanResultActivity.class));
//        }
//    }

}