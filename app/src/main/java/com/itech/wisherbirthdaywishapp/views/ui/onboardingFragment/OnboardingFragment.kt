package com.itech.wisherbirthdaywishapp.views.ui.onboardingFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {
    private lateinit var binding:FragmentOnboardingBinding
    private lateinit var listOfOnBoardingItems:List<ViewPagerDataModel>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnboardingBinding.bind(view)
        setUpOnboardingItem()
    }

    private fun setUpOnboardingItem() {
        TODO("Not yet implemented")
    }
}