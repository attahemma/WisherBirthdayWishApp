package com.itech.wisherbirthdaywishapp.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itech.wisherbirthdaywishapp.R;

public class GiftsProfileAdapter extends RecyclerView.Adapter<GiftsProfileAdapter.Profile> {

    private int [] giftItems;

    public GiftsProfileAdapter(int[] giftItems){
        this.giftItems = giftItems;

    }
    @NonNull
    @Override
    public Profile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_gift_layout, parent, false);

        return new Profile(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Profile holder, int position) {
        int gift_item= giftItems[position];

        holder.cardImage.setImageResource(gift_item);
    }

    @Override
    public int getItemCount() {
        return giftItems.length;
    }

    public class Profile extends RecyclerView.ViewHolder {

        ImageView cardImage;
        public Profile(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
        }
    }
}
