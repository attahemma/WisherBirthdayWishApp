package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.itech.wisherbirthdaywishapp.R;
import com.itech.wisherbirthdaywishapp.model.entities.Gift;
import com.itech.wisherbirthdaywishapp.database.GiftStore;
import com.itech.wisherbirthdaywishapp.repositories.GiftRepository;
import com.itech.wisherbirthdaywishapp.views.utils.ConstantsKt;
import com.itech.wisherbirthdaywishapp.views.utils.GiftingInterface;

import java.util.ArrayList;
import java.util.List;


public class GiftsProfileFragment extends Fragment implements GiftingInterface {

    private RecyclerView recyclerView;
    private BottomSheetDialogFragment bottomSheet;
    private final List<Gift> mGifts = new ArrayList<>();
    private GiftsProfileViewModel viewModel;


    public GiftsProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gifts_profile, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this,
                new GiftsProfileViewModelFactory(new GiftRepository(getActivity().getApplicationContext())))
                .get(GiftsProfileViewModel.class);

        bottomSheet = new GiftBottomSheet();

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        viewModel.getFakeGiftsWithoutWishes().observe(getViewLifecycleOwner(), new Observer<List<Gift>>() {
            @Override
            public void onChanged(List<Gift> gifts) {
                if (!mGifts.isEmpty()) {
                    mGifts.clear();
                }
                mGifts.addAll(gifts);
//                giftsProfileAdapter = new GiftsProfileAdapter(mGifts, GiftsProfileFragment.this);
            }
        });

        GiftsProfileAdapter giftsProfileAdapter = new GiftsProfileAdapter(GiftStore.INSTANCE.getAvailableGifts(), GiftsProfileFragment.this);

        recyclerView.setAdapter(giftsProfileAdapter);
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