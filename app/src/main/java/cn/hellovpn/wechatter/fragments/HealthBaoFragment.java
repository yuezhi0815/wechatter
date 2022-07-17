package cn.hellovpn.wechatter.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import cn.hellovpn.wechatter.HealthListActivity;
import cn.hellovpn.wechatter.R;
import cn.hellovpn.wechatter.databinding.SlideHealthbaoBinding;

//import info.androidhive.viewpager2.R;

//import cn.hellovpn.wechatter.R;

public class HealthBaoFragment extends Fragment {
    SlideHealthbaoBinding binding;
    Button btnHealth, btnTripCard;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

       // View view = inflater.inflate(R.layout.slide_healthbao, container, false);


        binding = SlideHealthbaoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        btnHealth = binding.btnHealth;
        this.btnTripCard= binding.btnTripCard;
        //btnHealth = (Button) view.findViewById(R.id.btnHealth);

        btnHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // System.out.println("Yes");
                //Toast.makeText(getActivity(), "Health Clicked. ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(v.getContext(),
                        HealthListActivity.class));
            }
        });
        btnTripCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // System.out.println("Yes");
                Toast.makeText(getActivity(), "TripCard Clicked. ", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
