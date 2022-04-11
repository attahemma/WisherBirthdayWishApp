package com.itech.wisherbirthdaywishapp.database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "addFriendInfo")
public class AddFriendsInfo {


     @PrimaryKey(autoGenerate = true)
     public int id;

     @NonNull
     @ColumnInfo(name = "full_name")
     public String fullName;

     @ColumnInfo(name = "phone_number")
     public int phoneNumber;

     @ColumnInfo(name = "date_of_birth")
     public String dateOfBirth;

     public AddFriendsInfo( int id, @NonNull String fullName, int phoneNumber, String dateOfBirth) {
          this.id = id;
          this.fullName = fullName;
          this.phoneNumber = phoneNumber;
          this.dateOfBirth = dateOfBirth;
     }


     public int getId() {
          return id;
     }

     @NonNull
     public String getFullName() {
          return fullName;
     }

     public int getPhoneNumber() {
          return phoneNumber;
     }

     public String getDateOfBirth() {
          return dateOfBirth;
     }
}
