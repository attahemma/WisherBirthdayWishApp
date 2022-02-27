package com.itech.wisherbirthdaywishapp.views.ui.fetchFriendFromContactList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.UpcomingScreenRecyclerItemBinding
import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel
import com.itech.wisherbirthdaywishapp.views.utils.ContactScreenClickListener

class ContactListAdapter (
private var listOfFriends: List<UpcomingScreenModel>,
private var clickInterface: ContactScreenClickListener
) : RecyclerView.Adapter<ContactListAdapter.UpcomingScreenViewHolder>() {

    class UpcomingScreenViewHolder(val binding: UpcomingScreenRecyclerItemBinding) :
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
        with(holder) {
            with(listOfFriends[position]) {
                itemView.setOnClickListener { clickInterface.clickFriendCard(position) }

                binding.friendFullName.text = fullName

                if (date == null)
                    "Add date".also { binding.friendDateOfBirth.text = it }
                else
                    binding.friendDateOfBirth.text = date

                if (contactImage != null)
                    binding.friendProfileImage.setImageBitmap(contactImage)
                else
                    binding.friendProfileImage.setImageResource(R.drawable.profile_image)

            }
        }
    }
    override fun getItemCount() = listOfFriends.size
}