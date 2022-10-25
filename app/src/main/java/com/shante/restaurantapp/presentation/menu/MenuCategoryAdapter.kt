package com.shante.restaurantapp.presentation.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shante.restaurantapp.R
import com.shante.restaurantapp.databinding.MenuCategoryItemBinding
import com.shante.restaurantapp.domain.models.MenuCategory

class MenuCategoryAdapter(
    private val onClick: (menuCategory: MenuCategory) -> Unit
) : ListAdapter<MenuCategory, RecyclerView.ViewHolder>(DiffCallBack) {

    private var selectedItem: Int = -1

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MenuCategory -> R.layout.menu_category_item
            else -> error("idk what it is item type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.menu_category_item -> MenuItemViewHolder.from(parent, onClick)
            else -> error("View holder doesn't exist")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MenuItemViewHolder -> {
                if (selectedItem == position) {
                    setBackGround(holder, R.drawable.shaped_rectangle_bg_selected)
                    setTextColor(
                        holder,
                        ContextCompat.getColor(holder.itemView.context, R.color.text_pink)
                    )
                } else {
                    setBackGround(holder, R.drawable.shaped_rectangle_bg)
                    setTextColor(
                        holder,
                        ContextCompat.getColor(holder.itemView.context, R.color.text_gray)
                    )

                }
                holder.bindMenuCategoryItem(getItem(position))
            }
        }

        holder.itemView.setOnClickListener {
            if (selectedItem == holder.adapterPosition) return@setOnClickListener
            val previousItem: Int = selectedItem
            selectedItem = holder.adapterPosition
            notifyItemChanged(previousItem)
            notifyItemChanged(holder.adapterPosition)
        }
    }

    private fun setBackGround(holder: RecyclerView.ViewHolder, resourceBackground: Int) {
        holder.itemView.setBackgroundResource(resourceBackground)
    }

    private fun setTextColor(holder: RecyclerView.ViewHolder, color: Int) {
        (holder.itemView as TextView).setTextColor(color)
    }
}

class MenuItemViewHolder(
    private val binding: MenuCategoryItemBinding,
    private val onClick: (menuCategory: MenuCategory) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bindMenuCategoryItem(menuCategory: MenuCategory) {
        with(binding) {
            menuCategoryItem.text = menuCategory.categoryTitle
            menuCategoryItem.setOnClickListener {
                onClick(menuCategory)
            }
        }
    }

    companion object {
        fun from(
            parent: ViewGroup,
            onClick: (menuCategory: MenuCategory) -> Unit
        ): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = MenuCategoryItemBinding.inflate(inflater, parent, false)
            return MenuItemViewHolder(binding, onClick)
        }
    }

}

private object DiffCallBack : DiffUtil.ItemCallback<MenuCategory>() {

    override fun areItemsTheSame(oldItem: MenuCategory, newItem: MenuCategory): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MenuCategory, newItem: MenuCategory): Boolean {
        return oldItem.categoryTitle == newItem.categoryTitle
    }
}
