package com.android.domain.details.useCase

import com.android.domain.details.model.MerchantDomainModel
import com.android.domain.details.repo.DetailsRepository

class GetMerchantsUseCase (private val repository: DetailsRepository) {
    suspend operator fun invoke(vendorId:String): List<MerchantDomainModel> {
            return repository.getMerchants(vendorId)
    }
}