package com.itech.wisherbirthdaywishapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface AddFriendsInfoDao {

    @Query("SELECT * FROM addFriendInfo")
    List<AddFriendsInfo> getAll();

   @Insert
    void insertAddFriendsInfo (AddFriendsInfo addFriendsInfo);

   @Update
    void  updateAddFriendsInfo (AddFriendsInfo addFriendsInfo);

   @Delete
    void deleteAddFriendsInfo (AddFriendsInfo addFriendsInfo);


}
