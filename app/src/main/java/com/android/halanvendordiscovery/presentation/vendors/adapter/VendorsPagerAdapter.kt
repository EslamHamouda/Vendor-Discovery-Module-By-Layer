package com.android.halanvendordiscovery.presentation.vendors.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.domain.vendors.model.VendorsDomainModel
import com.android.halanvendordiscovery.databinding.ListItemVendorCategoryContentBinding

class VendorsPagerAdapter(private val listener: OnItemClickListener) : PagingDataAdapter<VendorsDomainModel, VendorsPagerAdapter.ViewHolder>(ItemCallback) {
    inner class ViewHolder(private val binding: ListItemVendorCategoryContentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val data = getItem(position)
            binding.tvVendorName.text = data?.nameAr
            binding.tvVendorAddress.text = data?.address
            binding.root.setOnClickListener {
                data?.id?.let { it1 -> listener.onVendorClick(it1) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemVendorCategoryContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    private object ItemCallback: DiffUtil.ItemCallback<VendorsDomainModel>() {
        override fun areItemsTheSame(oldItem: VendorsDomainModel, newItem: VendorsDomainModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: VendorsDomainModel, newItem: VendorsDomainModel): Boolean {
            return oldItem == newItem
        }
    }
    interface OnItemClickListener{
        fun onVendorClick(vendorId: String)
    }
}