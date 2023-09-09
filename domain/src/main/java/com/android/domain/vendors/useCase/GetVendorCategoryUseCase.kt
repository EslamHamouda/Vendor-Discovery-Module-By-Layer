package com.android.domain.vendors.useCase

import com.android.domain.vendors.model.VendorCategoryDomainModel
import com.android.domain.vendors.repo.VendorsRepository

class GetVendorCategoryUseCase (private val repository: VendorsRepository) {
    suspend operator fun invoke(): List<VendorCategoryDomainModel> {
            return repository.getVendorCategory()
    }
}