package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.itech.wisherbirthdaywishapp.database.GiftDatabase;
import com.itech.wisherbirthdaywishapp.model.dao.GiftDao;
import com.itech.wisherbirthdaywishapp.model.entities.Gift;
import com.itech.wisherbirthdaywishapp.model.entities.relations.GiftAndWish;

import java.util.List;

public class GiftRepository {
    private GiftDao giftDao;
    private LiveData<List<Gift>> mAllGifts;
    private LiveData<List<GiftAndWish>> mAllGiftsWithWishes;

    public GiftRepository(Application application) {
        GiftDatabase giftDatabase = GiftDatabase.Companion.getInstance(application);
        giftDao = giftDatabase.getGiftDao();
        mAllGiftsWithWishes = giftDao.getGiftsWithWishes();
        mAllGifts = giftDao.getGifts();
    }

    public LiveData<List<Gift>> getAllGifts() {
        return mAllGifts;
    }

    public LiveData<List<GiftAndWish>> getAllGiftsWithWishes() {
        return mAllGiftsWithWishes;
    }

    public void insert(Gift gift) {
        GiftDatabase.Companion.getExecutor().execute(() ->{
            giftDao.insertGift(gift);
        });
    }
}
