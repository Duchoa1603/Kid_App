package com.example.apphoctap.fragment;

import static com.example.apphoctap.MainActivity.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apphoctap.R;


public class HoSoFragment extends Fragment {
    private TextView tvname,tvemail;

    public HoSoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ho_so, container, false);

        tvname = view.findViewById(R.id.tvname);
        tvname.setText("Меня зовут : \n" + user.getUserName());

        tvemail = view.findViewById(R.id.tvemail);
        tvemail.setText("Почта : \n" + user.getEmail());

        return view;
    }
}