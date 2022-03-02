import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itech.wisherbirthdaywishapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class GiftsProfileAdapter extends RecyclerView.Adapter<GiftsProfileAdapter.Profile> {
 static final List<GiftItems> GIFT_ITEMS = new ArrayList<>();

    @NonNull
    @Override
    public GiftsProfileAdapter.Profile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_gift_layout, parent, false);

        return new GiftsProfileAdapter.Profile(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiftsProfileAdapter.Profile holder, int position) {
        GiftItems giftItems = GIFT_ITEMS.get(position);

        Uri image = giftItems.getImage();
        holder.cardImage.setImageURI(image);
    }

    @Override
    public int getItemCount() {
        return GIFT_ITEMS.size();
    }

    public class Profile extends RecyclerView.ViewHolder {

        ImageView cardImage;
        public Profile(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
        }
    }
}
