package com.itech.wisherbirthdaywishapp.views.ui.onboardingFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.databinding.OnboardingviewpagerLayoutBinding

class OnboardingFragmentViewPagerAdapter():RecyclerView.Adapter<OnboardingFragmentViewPagerAdapter.OnboardingViewHolder>() {
    inner class OnboardingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val binding = OnboardingviewpagerLayoutBinding.bind(itemView)
        private val image = binding.onboardingImageView
        private val title = binding.tvTitle
        private val description = binding.tvDescription

        fun bind(item:ViewPagerDataModel){
            image.setImageResource(item.onBoardingImage)
            item.Title.also { title.text = it }
            item.Description.also { description.text = it }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<ViewPagerDataModel>(){
        override fun areItemsTheSame(
            oldItem: ViewPagerDataModel,
            newItem: ViewPagerDataModel
        ): Boolean {
            return oldItem.onBoardingImage == newItem.onBoardingImage
        }

        override fun areContentsTheSame(
            oldItem: ViewPagerDataModel,
            newItem: ViewPagerDataModel
        ): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,differCallBack)
    fun submitList(list: List<ViewPagerDataModel>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.onboardingviewpager_layout, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
            val item = differ.currentList[position]
            holder.bind(item)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}