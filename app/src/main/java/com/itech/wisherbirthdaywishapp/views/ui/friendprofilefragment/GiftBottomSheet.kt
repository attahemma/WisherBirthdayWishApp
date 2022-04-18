package com.itech.wisherbirthdaywishapp.views.ui.friendprofilefragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.model.entities.Gift
import com.itech.wisherbirthdaywishapp.views.utils.GIFT_ITEM_BUNDLE_KEY
import com.itech.wisherbirthdaywishapp.views.utils.GiftingInterface

class GiftBottomSheet : BottomSheetDialogFragment() {
    companion object {
        const val TAG = "GiftBottomSheet"
    }


    private lateinit var imgGiftImage: ImageView
    private var currentGift: Gift? = null
    private lateinit var btnSendGift: Button
    private lateinit var etWish: EditText
    private lateinit var giftingInterface: GiftingInterface


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
        giftingInterface = GiftsProfileFragment()
        imgGiftImage = view.findViewById(R.id.imgBottomSheetGift)
        btnSendGift = view.findViewById(R.id.btnSendGift)
        etWish = view.findViewById(R.id.etWish)

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
            imgGiftImage.setImageResource(gift.imageResource)
        } else {
            imgGiftImage.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }
}