package com.android.domain.vendors.repo

import androidx.paging.PagingData
import com.android.domain.vendors.model.VendorCategoryDomainModel
import com.android.domain.vendors.model.VendorsDomainModel
import kotlinx.coroutines.flow.Flow

interface VendorsRepository {
    suspend fun getVendorCategory(): List<VendorCategoryDomainModel>
    suspend fun getVendors(vendorId: String? = null, searchKey: String? = null):
            Flow<PagingData<VendorsDomainModel>>
}