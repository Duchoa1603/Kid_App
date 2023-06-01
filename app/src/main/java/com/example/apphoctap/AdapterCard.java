package com.example.apphoctap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphoctap.model.CardCommon;

import java.util.ArrayList;
import java.util.List;

public class AdapterCard extends  RecyclerView.Adapter<AdapterCard.ViewHolder>{
    private Context mContext;

    private IOnclickItem iOnclickItem;
    private List<CardCommon> mHeros;

    private int type;

    public AdapterCard(Context mContext, List<CardCommon> mHeros, IOnclickItem iOnclickItem, int type) {
        this.mContext = mContext;
        this.mHeros = mHeros;
        this.iOnclickItem = iOnclickItem;
        this.type = type;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView;
        if (type == 1 || type == 2) {
            heroView = inflater.inflate(R.layout.item_card, parent, false);
        }else {
            heroView = inflater.inflate(R.layout.item_cardso, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardCommon hero = mHeros.get(position);
        if(type == 1 || type == 3) {
            holder.mImageHero.setImageResource(hero.getImage());
        } else {
            holder.mImageHero.setBackgroundColor(Color.parseColor(hero.getColor()));
        }
        holder.setOnClick(hero);
    }

    @Override
    public int getItemCount() {
        return mHeros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageHero;
        private Animation mAlphaAnimation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageHero = itemView.findViewById(R.id.imageviewCard);
            mAlphaAnimation =   AnimationUtils.loadAnimation(mContext,R.anim.alpha_animation);
        }
        public void setOnClick(CardCommon cardCommon) {
            itemView.setOnClickListener(view -> {
                mImageHero.startAnimation(mAlphaAnimation);
                iOnclickItem.ItemOnclick(cardCommon);
            });
        }
    }
}
