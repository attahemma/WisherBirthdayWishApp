package com.itech.wisherbirthdaywishapp.views.ui.splashScreenFragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {
    companion object {
        const val SPLASH_SCREEN_DELAY = 3000L
    }

    private lateinit var binding: FragmentSplashScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashScreenBinding.bind(view)

        Handler().postDelayed(
            {
                NavigateToOnBoardingFragment(this).run()
            },
            SPLASH_SCREEN_DELAY
        )
    }

}

class NavigateToOnBoardingFragment(private val fragment: Fragment) : Runnable {
    override fun run() {
        findNavController(fragment = fragment)
            .navigate(R.id.action_splashScreenFragment_to_onboardingFragment)
    }

}