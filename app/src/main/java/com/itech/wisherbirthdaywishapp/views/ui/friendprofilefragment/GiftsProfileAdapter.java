package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itech.wisherbirthdaywishapp.R;
import com.itech.wisherbirthdaywishapp.database.Gift;
import com.itech.wisherbirthdaywishapp.views.utils.ConstantsKt;
import com.itech.wisherbirthdaywishapp.views.utils.GiftingInterface;

import java.util.ArrayList;
import java.util.List;

public class GiftsProfileAdapter extends RecyclerView.Adapter<GiftsProfileAdapter.Profile> {

    private ArrayList<Gift> mGifts;
    private GiftingInterface mGiftingInterface;


    public GiftsProfileAdapter(ArrayList<Gift> gifts, GiftingInterface giftingInterface) {
        this.mGifts = gifts;
        this.mGiftingInterface = giftingInterface;
    }

    @NonNull
    @Override
    public Profile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_gift_layout, parent, false);
        return new Profile(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Profile holder, int position) {
        Gift currentGift = mGifts.get(position);
        holder.bind(currentGift, mGiftingInterface);
    }


    @Override
    public int getItemCount() {
        return mGifts.size();
    }


    public class Profile extends RecyclerView.ViewHolder {

        ImageView cardImage;

        public Profile(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
        }

        public void bind(final Gift gift, final GiftingInterface giftingInterface) {
            cardImage.setImageResource(gift.getResource());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    giftingInterface.openGiftBottomSheet(gift);
                }
            });
        }
    }
}
