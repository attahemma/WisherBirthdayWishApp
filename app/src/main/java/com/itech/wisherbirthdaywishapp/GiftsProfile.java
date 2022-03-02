package com.itech.wisherbirthdaywishapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GiftsProfile extends Fragment {


    public GiftsProfile() {
        // Required empty public constructor
    }
   private int [] gifts = {R.drawable.ballon, R.drawable.cake, R.drawable.flower,
   R.drawable.ballon, R.drawable.cake, R.drawable.flower};



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_gifts_profile, container, false);
    }
}