package com.android.halanvendordiscovery.presentation.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.domain.details.useCase.GetMerchantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getMerchantsUseCase: GetMerchantsUseCase) :
    ViewModel() {

    private val _getMerchantsResponse: MutableStateFlow<DetailsStates> =
        MutableStateFlow(DetailsStates.Loading(true))
    val getMerchantsResponse = _getMerchantsResponse.asStateFlow()

    fun getMerchants(vendorId: String) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) { getMerchantsUseCase(vendorId) }
                _getMerchantsResponse.value = DetailsStates.Loading(false)
                _getMerchantsResponse.value = DetailsStates.Success(result)
            } catch (throwable: Throwable) {
                _getMerchantsResponse.value = DetailsStates.Loading(false)
                _getMerchantsResponse.value = DetailsStates.Failure(throwable)
            }
        }
    }
}