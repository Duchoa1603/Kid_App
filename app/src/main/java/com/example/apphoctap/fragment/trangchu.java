package com.example.apphoctap.fragment;

import static com.example.apphoctap.MainActivity.user;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apphoctap.R;


public class trangchu extends Fragment {
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5,imageView6;
    private TextView textView1,textView2,textView5;

    public trangchu() {
        // Required empty public constructor
    }

    public interface CommunicationInterface {
        void onClickTopFragment(String str);
    }

    CommunicationInterface listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CommunicationInterface) {
            listener = (CommunicationInterface) context;
        } else {
            throw new RuntimeException(context.toString() + "Can phai implement");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trangchu, container, false);
        imageView1 = view.findViewById(R.id.imageView3);
        imageView2 = view.findViewById(R.id.imageView4);
        imageView3 = view.findViewById(R.id.imageView5);
        imageView4 = view.findViewById(R.id.imageView6);
        imageView5 = view.findViewById(R.id.imageView7);


        textView1 = view.findViewById(R.id.textView3);
        textView1.setText("ПРИВЕТ "+ user.getUserName());

        imageView1.setOnClickListener(view1 ->{
            listener.onClickTopFragment("CHUCHU");
        });

        imageView2.setOnClickListener(view1 ->{
            listener.onClickTopFragment("CHUSO");
        });

        imageView3.setOnClickListener(view1 ->{
            listener.onClickTopFragment("DOANCHU");
        });

        imageView4.setOnClickListener(view1 ->{
            listener.onClickTopFragment("COLOR");
        });

        imageView5.setOnClickListener(view1 ->{
            listener.onClickTopFragment("TINHTOAN");
        });

        return view;
    }
}