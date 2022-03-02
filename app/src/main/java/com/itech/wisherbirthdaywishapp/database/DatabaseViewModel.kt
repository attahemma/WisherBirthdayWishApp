package com.itech.wisherbirthdaywishapp.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DatabaseViewModel(application: Application): AndroidViewModel(application) {
    private val userDao = FriendListDatabase.getDatabase(application).friendList()

    private val repository:FriendRepository = FriendRepository(userDao)
    val readAllData: LiveData<List<UpcomingScreenModel>> = repository.readAllData


    fun addUser(friend:UpcomingScreenModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(friend)
        }
    }
}