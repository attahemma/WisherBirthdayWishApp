package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.itech.wisherbirthdaywishapp.R;
import com.itech.wisherbirthdaywishapp.model.entities.Gift;
import com.itech.wisherbirthdaywishapp.views.utils.GiftingInterface;

import java.util.List;

public class GiftsProfileAdapter extends ListAdapter<Gift, GiftsProfileAdapter.GiftViewHolder> {

    private GiftingInterface mGiftingInterface;

    protected GiftsProfileAdapter(@NonNull DiffUtil.ItemCallback<Gift> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public GiftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_gift_layout, parent, false);
        return new GiftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiftViewHolder holder, int position) {
        Gift currentGift = getItem(position);
        mGiftingInterface = new GiftsProfileFragment();
        holder.bind(currentGift, mGiftingInterface);
    }




    public class GiftViewHolder extends RecyclerView.ViewHolder {

        ImageView cardImage;

        public GiftViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
        }

        public void bind(final Gift gift, final GiftingInterface giftingInterface) {
            cardImage.setImageResource(gift.getImageResource());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    giftingInterface.openGiftBottomSheet(gift);
                }
            });
        }
    }

    static class GiftDiff extends DiffUtil.ItemCallback<Gift> {

        @Override
        public boolean areItemsTheSame(@NonNull Gift oldItem, @NonNull Gift newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Gift oldItem, @NonNull Gift newItem) {
            return oldItem.getId().equals(newItem.getId());
        }
    }
}
