package com.android.domain.vendors.useCase

import androidx.paging.PagingData
import com.android.domain.vendors.model.VendorsDomainModel
import com.android.domain.vendors.repo.VendorsRepository
import kotlinx.coroutines.flow.Flow


class GetVendorsUseCase (private val repository: VendorsRepository) {
    suspend operator fun invoke(
        vendorId: String? = null,
        searchKey: String? = null
    ): Flow<PagingData<VendorsDomainModel>> {
        return repository.getVendors(vendorId, searchKey)
    }
}