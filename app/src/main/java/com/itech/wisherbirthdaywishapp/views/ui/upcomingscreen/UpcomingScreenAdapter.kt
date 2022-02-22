package com.itech.wisherbirthdaywishapp.views.ui.upcomingscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itech.wisherbirthdaywishapp.databinding.UpcomingScreenRecyclerItemBinding
import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel

class UpcomingScreenAdapter(private val listOfFriends: MutableList<UpcomingScreenModel>) :
    RecyclerView.Adapter<UpcomingScreenAdapter.UpcomingScreenViewHolder>() {
    inner class UpcomingScreenViewHolder(binding: UpcomingScreenRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingScreenViewHolder {
        val binding = UpcomingScreenRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UpcomingScreenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingScreenViewHolder, position: Int) {
        val current = listOfFriends[position]
        with(holder) {
            with(listOfFriends[position]) {

            }
        }
    }

    override fun getItemCount() = listOfFriends.size
}