package com.itech.wisherbirthdaywishapp.views.ui.overviewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.FragmentOverviewBinding
import com.itech.wisherbirthdaywishapp.model.entities.UpcomingScreenModel
import com.itech.wisherbirthdaywishapp.views.ui.upcomingscreen.UpcomingScreenAdapter
import com.itech.wisherbirthdaywishapp.views.utils.UpcomingScreenClickInterface

class OverviewFragment : Fragment(), UpcomingScreenClickInterface {
    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvAdapter: UpcomingScreenAdapter
    private var isVisibleFab = false
//    private lateinit var androidViewModel: DatabaseViewModel
    private var listOfFriends = mutableListOf<UpcomingScreenModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        androidViewModel = ViewModelProvider(this).get(DatabaseViewModel::class.java)
        setClickListeners()
        listOfFriends.add(UpcomingScreenModel(1, fullName = "Paul", date = "10-03-2022"))
        listOfFriends.add(UpcomingScreenModel(1, fullName = "johnson", date = "10-03-2022"))
        listOfFriends.add(UpcomingScreenModel(1, fullName = "johnson", date = "10-03-2022"))
        listOfFriends.add(UpcomingScreenModel(1, fullName = "fish", date = "10-03-2022"))
        listOfFriends.add(UpcomingScreenModel(1, fullName = "Cram", date = "10-03-2022"))
        rvAdapter = UpcomingScreenAdapter(listOfFriends, this)
        binding.overviewScreenRv.adapter = rvAdapter

//        androidViewModel.readAllData.observe(viewLifecycleOwner) {
//            if (it != null){
//                rvAdapter = UpcomingScreenAdapter(it, this)
//                binding.overviewScreenRv.adapter = rvAdapter
//            }else{
//                rvAdapter = UpcomingScreenAdapter(listOfFriends, this)
//                binding.overviewScreenRv.adapter = rvAdapter
//            }
//        }
        rvAdapter = UpcomingScreenAdapter(listOfFriends, this)


        binding.overviewScreenRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = rvAdapter
            setHasFixedSize(true)
        }
    }

    private fun setClickListeners() {
        binding.addContact.setOnClickListener {
            if (isVisibleFab){
                binding.fromContact.visibility = View.GONE
                binding.addManually.visibility = View.GONE
                binding.addContact.setImageResource(R.drawable.ic_baseline_add_24)
                isVisibleFab=false

            }else{

                binding.fromContact.visibility = View.VISIBLE
                binding.addManually.visibility = View.VISIBLE
                binding.addContact.setImageResource(R.drawable.ic_baseline_shuffle_24)
                isVisibleFab=true
            }
        }
        binding.fromContact.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_overview_to_fetchFriendsFromContact)

        }
        binding.addManually.setOnClickListener {
            Toast.makeText(
                context,
                "should navigate to add contact fragment",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun clickFriendCard(position: Int) {
        Toast.makeText(requireContext(), "You clicked item $position", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.giftsProfileFragment)
    }

    override fun showGiftBottomSheet(position: Int) {
        //
    }

    override fun closeBottomSheet() {
       //
    }
}