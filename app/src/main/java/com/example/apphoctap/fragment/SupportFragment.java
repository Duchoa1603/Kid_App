package com.example.apphoctap.fragment;

import static com.example.apphoctap.MainActivity.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apphoctap.R;

import androidx.preference.PreferenceFragmentCompat;

public class SupportFragment extends Fragment {
    private TextView tvname,tvemail;

    public SupportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//         Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_support, container, false);



        return view;

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_support);

    }


}