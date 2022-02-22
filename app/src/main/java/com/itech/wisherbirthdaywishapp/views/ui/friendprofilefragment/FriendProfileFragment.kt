package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.itech.wisherbirthdaywishapp.databinding.FragmentFriendProfileBinding

class FriendProfileFragment : Fragment() {
    private var _binding: FragmentFriendProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFriendProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addBirthDateBtn.setOnClickListener {
            DatePickerDialogFragment().show(
                childFragmentManager,
                ""
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}