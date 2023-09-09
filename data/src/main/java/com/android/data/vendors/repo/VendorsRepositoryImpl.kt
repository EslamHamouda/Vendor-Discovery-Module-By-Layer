package com.android.data.vendors.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.android.data.vendors.mapper.VendorCategoryDomainMapper
import com.android.domain.vendors.model.VendorCategoryDomainModel
import com.android.domain.vendors.repo.VendorsRepository
import com.android.data.vendors.service.VendorsService


class VendorsRepositoryImpl (private val service: VendorsService) :
    VendorsRepository {

    override suspend fun getVendorCategory(): List<VendorCategoryDomainModel> {
        val vendorsResponse = service.getVendorCategory()
        return vendorsResponse.data?.map { dto -> VendorCategoryDomainMapper.toDomain(dto) }
            .orEmpty()
    }

    override suspend fun getVendors(
        vendorId: String?,
        searchKey: String?
    ) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                VendorsPagingSource(vendorId, searchKey, service)
            }, initialKey = 0
        ).flow
}