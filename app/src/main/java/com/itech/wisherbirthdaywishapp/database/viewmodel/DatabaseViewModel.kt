package com.itech.wisherbirthdaywishapp.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itech.wisherbirthdaywishapp.database.db.FriendListDatabase
import com.itech.wisherbirthdaywishapp.database.repository.FriendRepositoryImpl
import com.itech.wisherbirthdaywishapp.database.repository.IFriendRepository
import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatabaseViewModel @Inject constructor(
    private val friendRepository: IFriendRepository
): ViewModel() {
    val readAllData: LiveData<List<UpcomingScreenModel>> = friendRepository.readAllData()

    fun addUser(friend:UpcomingScreenModel){
        viewModelScope.launch(Dispatchers.IO) {
            friendRepository.addUser(friend)
        }
    }
}