package com.android.halanvendordiscovery.presentation.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.domain.details.model.MerchantDomainModel
import com.android.halanvendordiscovery.databinding.ListItemMerchantBinding

class MerchantsAdapter(private val listener: OnItemClickListener) :
    ListAdapter<MerchantDomainModel, MerchantsAdapter.ViewHolder>(ItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemMerchantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ListItemMerchantBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MerchantDomainModel) {
            binding.tvMerchantName.text = item.arabicName
            binding.tvMerchantAddress.text = item.address
            binding.ivPhone.setOnClickListener {
                listener.onPhoneClick(item.phoneNumber)
            }
            binding.ivMap.setOnClickListener {
                listener.onLocationClick(item.latitude, item.longitude)
            }
        }
    }
   private object ItemCallback : DiffUtil.ItemCallback<MerchantDomainModel>() {
        override fun areItemsTheSame(oldItem: MerchantDomainModel, newItem: MerchantDomainModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MerchantDomainModel, newItem: MerchantDomainModel): Boolean {
            return oldItem == newItem
        }
    }
    interface OnItemClickListener {
        fun onLocationClick(latitude: Double, longitude: Double)
        fun onPhoneClick(phone: String)
    }
}
