package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.FragmentDatePickerDialogBinding

class DatePickerDialogFragment: DialogFragment(R.layout.fragment_date_picker_dialog) {

//    private lateinit var dialog: DialogFragment
    private lateinit var binding: FragmentDatePickerDialogBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDatePickerDialogBinding.bind(view)

//        dialog = DialogFragment()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isCancelable = false
        binding.positiveButton.setOnClickListener {
            dismiss()
        }
    }
}