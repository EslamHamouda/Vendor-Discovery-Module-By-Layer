package com.android.halanvendordiscovery.presentation.vendors.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.android.domain.vendors.model.VendorsDomainModel
import com.android.domain.vendors.useCase.GetVendorCategoryUseCase
import com.android.domain.vendors.useCase.GetVendorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class VendorsViewModel @Inject constructor(
    private val getVendorCategoryUseCase: GetVendorCategoryUseCase,
    private val getVendorsUseCase: GetVendorsUseCase
) :
    ViewModel() {

    private val _getVendorCategoryResponse: MutableStateFlow<VendorCategoryStates> =
        MutableStateFlow(VendorCategoryStates.Loading(true))
    val getVendorCategoryResponse = _getVendorCategoryResponse.asStateFlow()

    fun getVendorCategory() {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) { getVendorCategoryUseCase() }
                _getVendorCategoryResponse.value = VendorCategoryStates.Loading(false)
                _getVendorCategoryResponse.value = VendorCategoryStates.Success(result)
            } catch (throwable: Throwable) {
                _getVendorCategoryResponse.value = VendorCategoryStates.Loading(false)
                _getVendorCategoryResponse.value = VendorCategoryStates.Failure(throwable)
            }
        }
    }

    private var _getVendorsResponse: Flow<PagingData<VendorsDomainModel>> = emptyFlow()
    val getVendorsResponse
        get() = _getVendorsResponse

    fun getVendors(
        vendorId: String? = null,
        searchKey: String? = null
    ) {
        viewModelScope.launch {
            _getVendorsResponse = getVendorsUseCase(
                vendorId,
                searchKey
            ).cachedIn(viewModelScope).flowOn(Dispatchers.IO)
        }
    }
}