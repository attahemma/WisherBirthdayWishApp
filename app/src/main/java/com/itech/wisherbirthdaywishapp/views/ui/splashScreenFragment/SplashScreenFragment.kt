package com.itech.wisherbirthdaywishapp.views.ui.splashScreenFragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import android.view.WindowManager
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.FragmentSplashScreenBinding
import com.itech.wisherbirthdaywishapp.views.utils.SPLASH_SCREEN_DELAY


class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {
    private lateinit var binding: FragmentSplashScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashScreenBinding.bind(view)

        Handler().postDelayed(
            {
                if (onBoardingFinished())
                        findNavController()
                            .navigate(R.id.action_splashScreenFragment_to_welcomeScreenFragment)
                    else
                         findNavController()
                             .navigate(R.id.action_splashScreenFragment_to_onboardingFragment, null,
                             NavOptions.Builder()
                                 .setPopUpTo(R.id.splashScreenFragment, true).build())

            },
            SPLASH_SCREEN_DELAY
        )
    }
    private fun onBoardingFinished():Boolean{
        val sharedPref = requireActivity()
            .getSharedPreferences("onboarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("finished", false)
    }
}
