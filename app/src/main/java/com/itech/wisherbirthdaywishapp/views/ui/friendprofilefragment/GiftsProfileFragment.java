package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.itech.wisherbirthdaywishapp.R;
import com.itech.wisherbirthdaywishapp.database.Gift;
import com.itech.wisherbirthdaywishapp.database.GiftStore;
import com.itech.wisherbirthdaywishapp.views.utils.ConstantsKt;
import com.itech.wisherbirthdaywishapp.views.utils.GiftingInterface;


public class GiftsProfileFragment extends Fragment implements GiftingInterface {

    private RecyclerView recyclerView;
    private BottomSheetDialogFragment bottomSheet;
    private GiftsProfileAdapter giftsProfileAdapter;

    public GiftsProfileFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gifts_profile, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        giftsProfileAdapter = new GiftsProfileAdapter(GiftStore.INSTANCE.getAvailableGifts(), this);

        recyclerView.setAdapter(giftsProfileAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomSheet = new GiftBottomSheet();
    }


    @Override
    public void openGiftBottomSheet(@Nullable Gift gift) {
        Bundle giftBundle = new Bundle();
        giftBundle.putSerializable(ConstantsKt.GIFT_ITEM_BUNDLE_KEY, gift);
        bottomSheet.setArguments(giftBundle);
        bottomSheet.show(
                requireActivity().getSupportFragmentManager(),
                GiftBottomSheet.TAG
        );
    }
}