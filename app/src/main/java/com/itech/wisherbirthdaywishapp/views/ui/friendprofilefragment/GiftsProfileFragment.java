package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.itech.wisherbirthdaywishapp.R;
import com.itech.wisherbirthdaywishapp.model.entities.Gift;
import com.itech.wisherbirthdaywishapp.database.GiftStore;
import com.itech.wisherbirthdaywishapp.views.utils.ConstantsKt;
import com.itech.wisherbirthdaywishapp.views.utils.GiftingInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GiftsProfileFragment extends Fragment implements GiftingInterface {

    private RecyclerView recyclerView;
    private BottomSheetDialogFragment bottomSheet;
    private GiftViewModel viewModel;
    private GiftsProfileAdapter giftsProfileAdapter = null;

    public GiftsProfileFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gifts_profile, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bottomSheet = new GiftBottomSheet();

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        viewModel = new ViewModelProvider(requireActivity()).get(GiftViewModel.class);

        giftsProfileAdapter = new GiftsProfileAdapter(new GiftsProfileAdapter.GiftDiff());
        recyclerView.setAdapter(giftsProfileAdapter);
     //   recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        viewModel.getAllGifts().observe(getViewLifecycleOwner(), gifts -> {
            giftsProfileAdapter.submitList(gifts);
        });
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