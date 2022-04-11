package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.database.Gift
import com.itech.wisherbirthdaywishapp.views.utils.GIFT_ITEM_BUNDLE_KEY

class GiftBottomSheet : BottomSheetDialogFragment() {
    companion object {
        const val TAG = "GiftBottomSheet"
    }

    private lateinit var tvGiftPrice: TextView
    private lateinit var tvGiftName: TextView
    private lateinit var imgGiftImage: ImageView
    private var currentGift: Gift? = null
    private lateinit var btnSendGift: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentGift = this.arguments?.getSerializable(GIFT_ITEM_BUNDLE_KEY) as Gift?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.gift_bottom_sheet_content,
        container, false
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvGiftName = view.findViewById(R.id.tvGiftName)
        tvGiftPrice = view.findViewById(R.id.tvGiftPrice)
        imgGiftImage = view.findViewById(R.id.imgBottomSheetGift)
        btnSendGift = view.findViewById(R.id.btnSendGift)

        currentGift?.let { gift ->
            populateViews(gift)
        }

        btnSendGift.setOnClickListener {
            Toast.makeText(
                requireActivity(),
                "You sent this gift with id ${currentGift?.id}",
                Toast.LENGTH_SHORT
            ).show()
        }


    }


    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        populateViews(null)
    }

    private fun populateViews(gift: Gift?) {
        if (gift != null) {
            tvGiftPrice.text = "$${gift.price.toString()}"
            tvGiftName.text = gift.name
            imgGiftImage.setImageResource(gift.resource)
        } else {
            tvGiftPrice.text = ""
            tvGiftName.text = ""
            imgGiftImage.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }
}