package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment

import androidx.lifecycle.*
import com.itech.wisherbirthdaywishapp.database.GiftStore
import com.itech.wisherbirthdaywishapp.model.entities.Gift
import com.itech.wisherbirthdaywishapp.model.entities.Wish
import com.itech.wisherbirthdaywishapp.model.entities.relations.GiftAndWish
import com.itech.wisherbirthdaywishapp.repositories.GiftRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class GiftsProfileViewModel(private val repository: GiftRepository) : ViewModel() {

    private var _giftsWithoutWishes: LiveData<List<Gift>>? = null
    private var _giftsWithWishes: LiveData<List<GiftAndWish>>? = null
    private var _giftWithWish: LiveData<GiftAndWish>? = null

    fun insertWish(wish: Wish) {
        viewModelScope.launch {
            repository.insertWish(wish)
        }
    }

    suspend fun insertGift(gift: Gift) {
        viewModelScope.launch {
            repository.insertGift(gift)
        }
    }

    fun getGiftsWithoutWishes(): LiveData<List<Gift>> {
        viewModelScope.launch {
            _giftsWithoutWishes = MutableLiveData(repository.getGiftsWithoutWishes())
        }
        return _giftsWithoutWishes!!
    }

    fun getGiftsWithWishes(): LiveData<List<GiftAndWish>> {
        viewModelScope.launch {
            _giftsWithWishes = MutableLiveData(repository.getGiftsWithWishes())
        }
        return _giftsWithWishes!!
    }

    fun getGiftWithWishById(id: String): LiveData<GiftAndWish> {
        viewModelScope.launch {
            _giftWithWish = MutableLiveData(repository.getGiftWithWishById(id))
        }
        return _giftWithWish!!
    }


    fun getFakeGiftsWithoutWishes(): LiveData<List<Gift>> {
        viewModelScope.launch {
            _giftsWithoutWishes = MutableLiveData(GiftStore.availableGifts)
        }
        return _giftsWithoutWishes!!
    }

}

class GiftsProfileViewModelFactory(private val repository: GiftRepository) :
    ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GiftsProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GiftsProfileViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown Parameter")
    }

}