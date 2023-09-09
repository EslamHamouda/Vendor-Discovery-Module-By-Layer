package com.android.data.vendors.mapper

import com.android.domain.vendors.model.VendorCategoryDomainModel
import com.android.data.vendors.model.response.VendorCategoryResponse

object VendorCategoryDomainMapper{
    fun toDomain(from: VendorCategoryResponse) = VendorCategoryDomainModel(
        id = from.id,
        name = from.name,
        arabicName = from.arabicName,
    )
}