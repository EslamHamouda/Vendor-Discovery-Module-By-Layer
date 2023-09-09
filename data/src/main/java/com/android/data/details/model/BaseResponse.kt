package com.android.data.details.model

data class BaseResponse<T>(
    var status: Int,
    var message: String?,
    var data: T?
)
