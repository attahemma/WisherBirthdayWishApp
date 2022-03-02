package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itech.wisherbirthdaywishapp.R;
import com.itech.wisherbirthdaywishapp.model.GiftsProfileAdapter;


public class GiftsProfileFragment extends Fragment {

     RecyclerView recyclerView;


    public GiftsProfileFragment() {
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

        View view = inflater.inflate(R.layout.fragment_gifts_profile, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        GiftsProfileAdapter giftsProfileAdapter = new GiftsProfileAdapter(gifts);

        recyclerView.setAdapter(giftsProfileAdapter);
        return view;
    }

}