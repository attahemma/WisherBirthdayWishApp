package com.itech.wisherbirthdaywishapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AddFriendsInfo.class}, version = 1)
public abstract class AddFriendsInfoDatabase extends RoomDatabase {

    public abstract AddFriendsInfoDao addFriendsInfoDao();

    private  static AddFriendsInfoDatabase INSTANCE;

    public static AddFriendsInfoDatabase getDataBaseInstance (Context context) {

        if(INSTANCE == null){

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AddFriendsInfoDatabase.class, "friend_info database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}
