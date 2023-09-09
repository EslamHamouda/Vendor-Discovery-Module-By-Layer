package com.android.data.details.model.response

import com.google.gson.annotations.SerializedName

data class MerchantRemoteModel(
    var id: String,
    var name: String,
    @SerializedName("arabic_name")
    var arabicName: String,
    @SerializedName("creation_date")
    var creationDate: Int?,
    var status: Int?,
    var address: String,
    var governorate: String,
    var longitude: Double,
    var latitude: Double,
    @SerializedName("phone_number")
    var phoneNumber: String,
    @SerializedName("branch_head_name")
    var branchHeadName: String,
    @SerializedName("branch_head_phone")
    var branchHeadPhone: String,
    var categories: ArrayList<String>?,
    var merchantId: String?,
    var vendor: VendorRemoteModel,
    var location: LocationRemoteModel
)
