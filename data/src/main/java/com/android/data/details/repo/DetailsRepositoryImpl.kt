package com.android.data.details.repo

import com.android.data.details.mapper.MerchantRemoteDomainMapper
import com.android.data.details.service.DetailsService
import com.android.domain.details.model.MerchantDomainModel
import com.android.domain.details.repo.DetailsRepository


class DetailsRepositoryImpl (private val service: DetailsService):
    DetailsRepository {
    override suspend fun getMerchants(vendorId: String): List<MerchantDomainModel> {
        val merchantsResponse = service.getMerchants(vendorId)
        return merchantsResponse.data?.merchants?.map { dto -> MerchantRemoteDomainMapper.toDomain(dto) }
            .orEmpty()
    }
}