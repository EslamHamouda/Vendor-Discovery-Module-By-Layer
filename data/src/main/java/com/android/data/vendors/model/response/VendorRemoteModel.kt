package com.android.data.vendors.model.response

import com.android.data.vendors.model.response.VendorPromotionRemoteModel
import com.google.gson.annotations.SerializedName

data class VendorRemoteModel(
    var id: String,
    var nameEn: String,
    var nameAr: String,
    var address: String,
    var lat: Double,
    var long: Double,
    var phone: String,
    var hasPromotion: Boolean?,
    var marketingName: String?,
    @SerializedName("promotion_list")
    var promotionList: ArrayList<VendorPromotionRemoteModel>?
)
