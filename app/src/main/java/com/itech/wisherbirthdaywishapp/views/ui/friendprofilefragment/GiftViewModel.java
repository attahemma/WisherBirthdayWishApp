package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.itech.wisherbirthdaywishapp.model.entities.Gift;
import com.itech.wisherbirthdaywishapp.model.entities.relations.GiftAndWish;

import java.util.List;

public class GiftViewModel extends AndroidViewModel {
    private GiftRepository repository;
    private final LiveData<List<Gift>> mAllGifts;
    private final LiveData<List<GiftAndWish>> mAllGiftsWithWishes;

    public GiftViewModel(@NonNull Application application) {
        super(application);
        repository = new GiftRepository(application);
        mAllGifts = repository.getAllGifts();
        mAllGiftsWithWishes = repository.getAllGiftsWithWishes();
    }

    public LiveData<List<Gift>> getAllGifts() {
        return mAllGifts;
    }

    public LiveData<List<GiftAndWish>> getAllGiftsWithWishes() {
        return mAllGiftsWithWishes;
    }

    public void insert(Gift gift) {
        repository.insert(gift);
    }
}
