package com.itech.wisherbirthdaywishapp.views.ui.overviewscreen

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.itech.wisherbirthdaywishapp.databinding.FragmentOverviewBinding
import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel
import com.itech.wisherbirthdaywishapp.views.ui.upcomingscreen.UpcomingScreenAdapter
import com.itech.wisherbirthdaywishapp.views.utils.READ_CONTACT
import com.itech.wisherbirthdaywishapp.views.utils.UpcomingScreenClickInterface

class OverviewFragment : Fragment(), UpcomingScreenClickInterface {
    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>
    private lateinit var rvAdapter: UpcomingScreenAdapter
    private val listOfFriends = mutableListOf<UpcomingScreenModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    showContact()
                } else {
                    binding.overviewScreenRv.visibility = View.GONE
                    binding.onError.visibility = View.VISIBLE
                    binding.retryRequest.visibility = View.VISIBLE
                }
            }
        // function to read contact
        readContact()
        binding.retryRequest.setOnClickListener { readContact() }


        binding.overviewScreenRv.apply {
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
        binding.overviewScreenRv.visibility = View.VISIBLE
        binding.onError.visibility = View.GONE
        binding.retryRequest.visibility = View.GONE
        Toast.makeText(requireContext(), "lskkssksssss", Toast.LENGTH_SHORT).show()
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
                val obj = UpcomingScreenModel(null, name, null)
                if (imageResourse != null) {
                    obj.contactImage = MediaStore.Images.Media.getBitmap(
                        requireActivity().contentResolver,
                        Uri.parse(imageResourse)
                    )
                } else {
                    obj.contactImage = null
                }

                listOfFriends.add(obj)
            }
        }
        rvAdapter = UpcomingScreenAdapter(listOfFriends, this)
        binding.overviewScreenRv.adapter = rvAdapter

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun clickFriendCard(position: Int) {
        Toast.makeText(requireContext(), "You clicked item $position", Toast.LENGTH_SHORT).show()
    }
}