package com.android.domain.details.repo

import com.android.domain.details.model.MerchantDomainModel

interface DetailsRepository {
    suspend fun getMerchants(vendorId:String): List<MerchantDomainModel>
}