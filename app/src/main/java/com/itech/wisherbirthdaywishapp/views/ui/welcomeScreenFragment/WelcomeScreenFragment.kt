package com.itech.wisherbirthdaywishapp.views.ui.welcomeScreenFragment

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.FragmentWelcomeScreenBinding
import com.itech.wisherbirthdaywishapp.views.utils.TextFormatter


class WelcomeScreenFragment : Fragment(R.layout.fragment_welcome_screen) {
   private lateinit var binding: FragmentWelcomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWelcomeScreenBinding.bind(view)

      binding.introText.text = TextFormatter
            .convertToSpannableString(
                "Let's Start",
                0, 5,
                Typeface.BOLD
            )



    }
}