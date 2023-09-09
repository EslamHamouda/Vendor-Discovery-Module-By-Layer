package com.android.data.vendors.mapper

import com.android.domain.vendors.model.VendorsDomainModel
import com.android.data.vendors.model.response.VendorRemoteModel

object VendorsDomainMapper{
    fun toDomain(from: VendorRemoteModel) = VendorsDomainModel(
        id = from.id,
        nameEn = from.nameEn,
        nameAr = from.nameAr,
        address = from.address
    )
}