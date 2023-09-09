package com.android.halanvendordiscovery.presentation.vendors.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.halanvendordiscovery.databinding.LoadStateLayoutBinding

class VendorsPagerLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<VendorsPagerLoadStateAdapter.LoadStateViewHolder>() {
    inner class LoadStateViewHolder(
        private val binding: LoadStateLayoutBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            binding.btnRetry.setOnClickListener {retry.invoke()}
            if (loadState is LoadState.Error) {
                binding.tvError.text = loadState.error.localizedMessage
            }
            binding.progressBar.progressBar.isVisible = loadState is LoadState.Loading
            binding.btnRetry.isVisible = loadState is LoadState.Error
            binding.tvError.isVisible = loadState is LoadState.Error
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): VendorsPagerLoadStateAdapter.LoadStateViewHolder {
        val binding =
            LoadStateLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return LoadStateViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: LoadStateViewHolder,
        loadState: LoadState
    ) = holder.bind(loadState)
}
