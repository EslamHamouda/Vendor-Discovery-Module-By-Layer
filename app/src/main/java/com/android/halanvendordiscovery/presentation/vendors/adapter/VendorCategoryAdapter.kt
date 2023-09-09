package com.android.halanvendordiscovery.presentation.vendors.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.domain.vendors.model.VendorCategoryDomainModel
import com.android.halanvendordiscovery.R
import com.android.halanvendordiscovery.databinding.ListItemVendorCategoryBinding


class VendorCategoryAdapter(private val listener: OnItemClickListener) :
    ListAdapter<VendorCategoryDomainModel, VendorCategoryAdapter.ViewHolder>(
        ItemCallback
    ) {
    private var currentSelectedItemIndex: Int = -1
    private var previousSelectedItemIndex: Int = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemVendorCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ListItemVendorCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: VendorCategoryDomainModel) {
            binding.categoryName.text = item.arabicName
            binding.categoryName.background = (
                    if (bindingAdapterPosition == currentSelectedItemIndex) {
                        ContextCompat.getDrawable(
                            binding.root.context,
                            R.drawable.bg_rounded_vendor_category_active
                        )
                    } else ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_rounded_vendor_category
                    )
                    )
            binding.categoryName.setTextColor(
                if (bindingAdapterPosition == currentSelectedItemIndex) {
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.progress_bar_color
                    )
                } else ContextCompat.getColor(
                    binding.root.context,
                    R.color.tv_primary_color
                )
            )
            binding.root.setOnClickListener {
                previousSelectedItemIndex = currentSelectedItemIndex
                currentSelectedItemIndex = bindingAdapterPosition
                notifyItemChanged(previousSelectedItemIndex)
                notifyItemChanged(currentSelectedItemIndex)
                listener.onCategoryClicked(item.id)
            }
        }
    }

    private object ItemCallback : DiffUtil.ItemCallback<VendorCategoryDomainModel>() {
        override fun areItemsTheSame(
            oldItem: VendorCategoryDomainModel,
            newItem: VendorCategoryDomainModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: VendorCategoryDomainModel,
            newItem: VendorCategoryDomainModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    interface OnItemClickListener {
        fun onCategoryClicked(categoryId: String)
    }
}