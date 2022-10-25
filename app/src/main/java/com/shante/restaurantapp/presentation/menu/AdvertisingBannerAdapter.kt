package com.shante.restaurantapp.presentation.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shante.restaurantapp.R
import com.shante.restaurantapp.databinding.AdvertisingBannerItemBinding
import com.shante.restaurantapp.domain.models.AdvertisingBannerItem

class AdvertisingBannerAdapter(
    private val onCLick: (advertisingBannerItem: AdvertisingBannerItem) -> Unit
) : ListAdapter<AdvertisingBannerItem, RecyclerView.ViewHolder>(DiffCallBackAdvertisingBannerItem) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is AdvertisingBannerItem -> R.layout.advertising_banner_item
            else -> error("idk what it is item type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.advertising_banner_item -> AdvertisingBannerViewHolder.from(parent, onCLick)
            else -> error("View holder doesn't exist")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AdvertisingBannerViewHolder -> holder.bindAdvertisingBannerItem(getItem(position))
        }
    }

}

class AdvertisingBannerViewHolder(
    private val binding: AdvertisingBannerItemBinding,
    private val onCLick: (advertisingBannerItem: AdvertisingBannerItem) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bindAdvertisingBannerItem(advertisingBannerItem: AdvertisingBannerItem) {
        with(binding) {
            advertisingBannerImage.setOnClickListener {
                onCLick(advertisingBannerItem)
            }
            Glide.with(advertisingBannerImage)
                .asDrawable()
                .load(advertisingBannerItem.source)
                .error(R.drawable.ic_no_image)
                .into(advertisingBannerImage)
        }
    }

    companion object {
        fun from(
            parent: ViewGroup,
            onClick: (advertisingBannerItem: AdvertisingBannerItem) -> Unit
        ): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = AdvertisingBannerItemBinding.inflate(inflater, parent, false)
            return AdvertisingBannerViewHolder(binding, onClick)
        }
    }

}

private object DiffCallBackAdvertisingBannerItem : DiffUtil.ItemCallback<AdvertisingBannerItem>() {

    override fun areItemsTheSame(
        oldItem: AdvertisingBannerItem,
        newItem: AdvertisingBannerItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: AdvertisingBannerItem,
        newItem: AdvertisingBannerItem
    ): Boolean {
        return oldItem.source == newItem.source
    }
}
