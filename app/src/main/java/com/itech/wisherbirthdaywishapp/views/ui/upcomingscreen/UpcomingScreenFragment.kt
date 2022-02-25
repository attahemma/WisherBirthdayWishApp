package com.itech.wisherbirthdaywishapp.views.ui.upcomingscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.itech.wisherbirthdaywishapp.databinding.FragmentUpcomingScreenBinding
import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel
import com.itech.wisherbirthdaywishapp.views.utils.UpcomingScreenClickInterface

class UpcomingScreenFragment : Fragment(), UpcomingScreenClickInterface {
    private var _binding: FragmentUpcomingScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: UpcomingScreenAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpcomingScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfFriends = mutableListOf(
            UpcomingScreenModel("Konohamaru Sarutobi", "02 Feb"),
            UpcomingScreenModel("Sakura Haruno", "22 Jun"),
            UpcomingScreenModel("Hyuga Hinata", "09 Dec"),
            UpcomingScreenModel("Hatake Kakashi", "15 Jan"),
            UpcomingScreenModel("Toneri Ōtsutsuki", "05 Mar"),
            UpcomingScreenModel("Uchiha Madara", "20 May"),
            UpcomingScreenModel("Uchiha Sasuke", "19 Aug"),
            UpcomingScreenModel("Uzumaki Naruto", "15 Apr"),
            UpcomingScreenModel("Uchiha Sarada", "23 Nov"),
            UpcomingScreenModel("Rock Lee", "30 Sep"),
            UpcomingScreenModel("Akimichi Choji", "11 Jul"),
            UpcomingScreenModel("Inuzuka Kiba", "28 Oct"),
        )

        adapter = UpcomingScreenAdapter(listOfFriends, this)
        binding.upcomingScreenRv.apply {
            adapter = adapter
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun clickFriendCard(position: Int) {
        Toast.makeText(requireContext(), "You clicked item $position", Toast.LENGTH_SHORT).show()
    }

    override fun showGiftBottomSheet(position: Int) {
        TODO("Not yet implemented")
    }

    override fun closeBottomSheet() {
        TODO("Not yet implemented")
    }
}