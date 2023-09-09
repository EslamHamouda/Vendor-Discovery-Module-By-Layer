package com.android.data.vendors.model

data class BaseResponse<T>(
    var status: Int,
    var message: String?,
    var data: T?
)
