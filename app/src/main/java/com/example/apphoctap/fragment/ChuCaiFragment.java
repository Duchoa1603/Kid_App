package com.example.apphoctap.fragment;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apphoctap.AdapterCard;
import com.example.apphoctap.DatasourceConst.DataBaseCommon;
import com.example.apphoctap.IOnclickItem;
import com.example.apphoctap.R;
import com.example.apphoctap.model.CardCommon;

import java.util.List;


public class ChuCaiFragment extends Fragment implements IOnclickItem {
    private RecyclerView recyclerView;
    private AdapterCard adapterCard;
    private List<CardCommon> list;
    public ChuCaiFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chu_cai, container, false);
        recyclerView = view.findViewById(R.id.recyclerHero);
        list = DataBaseCommon.getListAphabeta();
        adapterCard = new AdapterCard(getContext(),list,this,1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterCard);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        return view;
    }



    @Override
    public void ItemOnclick(CardCommon cardCommon) {
        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), cardCommon.getSound());
        mediaPlayer.start();
    }




}