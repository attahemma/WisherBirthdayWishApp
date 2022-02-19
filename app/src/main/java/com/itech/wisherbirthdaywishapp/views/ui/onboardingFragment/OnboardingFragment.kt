package com.itech.wisherbirthdaywishapp.views.ui.onboardingFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {
    private lateinit var binding: FragmentOnboardingBinding
    private lateinit var listOfOnBoardingItems: List<ViewPagerDataModel>
    private lateinit var adapter: OnboardingFragmentViewPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnboardingBinding.bind(view)
        setUpOnboardingItem()
        setUpIndicator()
        setUpCurrentIndicator(0)
    }

    private fun setUpOnboardingItem() {
        listOfOnBoardingItems = listOf(
            ViewPagerDataModel(R.drawable.onboard_1),
            ViewPagerDataModel(R.drawable.onboard_2)
        )
        adapter = OnboardingFragmentViewPagerAdapter()
        adapter.submitList(listOfOnBoardingItems)
        binding.onboardingViewpager.adapter = adapter
        binding.onboardingViewpager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setUpCurrentIndicator(position)
            }
        })
        (binding.onboardingViewpager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
        val onBoardingVp = binding.onboardingViewpager
        binding.btnNext.setOnClickListener {
            if (onBoardingVp.currentItem +1 < adapter.itemCount){
                onBoardingVp.currentItem +=1

            }else{
                navigateToLoginFragment()
            }
        }
        binding.btnPrevious.setOnClickListener {
            if (onBoardingVp.currentItem -1 < adapter.itemCount){
                onBoardingVp.currentItem -= 1
            }
        }
    }

    private fun navigateToLoginFragment() {
// navigate to login fragment
    }

    private fun setUpIndicator() {
        val indicators = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParam: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParam.setMargins(8, 0, 8, 0)


        for (i in indicators.indices) {
            indicators[i] = ImageView(context)
            indicators[i]?.let {
                it.setImageDrawable(
                    context?.let { it1 ->
                        ContextCompat.getDrawable(
                            it1,
                            R.drawable.unselected_circle
                        )
                    }
                )
                it.layoutParams = layoutParam
                binding.indicatorContainer.addView(it)
            }
        }

    }

    fun setUpCurrentIndicator(position: Int) {
        if (position == adapter.itemCount - 1) {
            "Done".also { binding.btnNext.text = it }
            binding.btnPrevious.visibility = View.VISIBLE
        } else {
            "Next".also { binding.btnNext.text = it }
            binding.btnPrevious.visibility = View.GONE

        }
        val childCount = binding.indicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = binding.indicatorContainer.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    context?.let {
                        ContextCompat.getDrawable(
                            it,
                            R.drawable.selected_background
                        )
                    }
                )
            } else {
                imageView.setImageDrawable(
                    context?.let {
                        ContextCompat.getDrawable(
                            it,
                            R.drawable.unselected_circle
                        )
                    }
                )
            }
        }
    }
}