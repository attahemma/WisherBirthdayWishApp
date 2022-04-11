package com.itech.wisherbirthdaywishapp.views.ui.fetchFriendFromContactList

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.FragmentFetchFreindFromContactBinding
import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel
import com.itech.wisherbirthdaywishapp.views.ui.upcomingscreen.UpcomingScreenAdapter
import com.itech.wisherbirthdaywishapp.views.utils.ContactScreenClickListener
import com.itech.wisherbirthdaywishapp.views.utils.UpcomingScreenClickInterface

class FetchFriendsFromContact : Fragment(R.layout.fragment_fetch_freind_from_contact),
    ContactScreenClickListener {
    private lateinit var binding:FragmentFetchFreindFromContactBinding
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>
    private lateinit var rvAdapter: ContactListAdapter
    private var listOfFriends = mutableListOf<UpcomingScreenModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFetchFreindFromContactBinding.bind(view)
        requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    showContact()
                } else {
                    binding.contactListRv.visibility = View.GONE
                    binding.onError.visibility = View.VISIBLE
                    binding.retryRequest.visibility = View.VISIBLE
                }
            }
        //try to read phone contact
        readContact()
        binding.retryRequest.setOnClickListener { readContact() }


        binding.contactListRv.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }


    }
    private fun readContact() {
        if (ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            showContact()
        }
        else {

            requestPermissionLauncher.launch(
                Manifest.permission.READ_CONTACTS
            )
        }

    }
    @SuppressLint("Range")
    private fun showContact() {
        binding.contactListRv.visibility = View.VISIBLE
        binding.onError.visibility = View.GONE
        binding.retryRequest.visibility = View.GONE
        //query phone contact list
        val contact = requireActivity().contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null, null
        )
        //check if contact is not empty
        if (contact != null) {
            while (contact.moveToNext()) {//continue looping through list of contact if it has an element
                //get contact name
                val name = contact
                    .getString(
                        contact.getColumnIndex(
                            ContactsContract
                                .CommonDataKinds.Phone.DISPLAY_NAME
                        )
                    )
                //get image if contact contain image
                val imageResourse = contact.getString(
                    contact.getColumnIndex
                        (ContactsContract.CommonDataKinds.Phone.PHOTO_URI)
                )
                //create an object of dataclass and pass to list for recycler view to display
                val obj = UpcomingScreenModel(1,null, name, null)
                if (imageResourse != null) {
                    obj.contactImage = MediaStore.Images.Media.getBitmap(
                        requireActivity().contentResolver,
                        Uri.parse(imageResourse)
                    )
                } else {
                    obj.contactImage = null
                }
                listOfFriends.add(obj)
                //androidViewModel.addUser(obj)
            }
        }
        val listOfF = listOfFriends.toList().sortedBy { it.fullName }
        rvAdapter = ContactListAdapter(listOfF, this)
        binding.contactListRv.adapter = rvAdapter
    }

    override fun clickFriendCard(position: Int) {
        Toast.makeText(requireContext(), "You clicked item ${position+1}", Toast.LENGTH_SHORT).show()
    }
}