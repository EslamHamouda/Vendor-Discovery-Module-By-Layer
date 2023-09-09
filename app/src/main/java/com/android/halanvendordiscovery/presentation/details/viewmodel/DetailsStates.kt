package com.android.halanvendordiscovery.presentation.details.viewmodel

import com.android.domain.details.model.MerchantDomainModel

sealed class DetailsStates {
    data class Success(val value: List<MerchantDomainModel>) : DetailsStates()
    data class Failure(val throwable: Throwable) : DetailsStates()
    data class Loading(val isLoading: Boolean) : DetailsStates()
}