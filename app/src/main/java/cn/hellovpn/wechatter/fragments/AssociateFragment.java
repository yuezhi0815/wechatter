package cn.hellovpn.wechatter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

//import cn.hellovpn.
import cn.hellovpn.wechatter.R;
//import info.androidhive.viewpager2.R;
//import info.androidhive.viewpager2.R;

public class AssociateFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.slide_associates, container, false);
    }
}
