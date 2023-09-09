package com.android.data.vendors.model.response

import com.android.data.vendors.model.response.VendorRemoteModel

data class VendorsResponse(
    var vendors: ArrayList<VendorRemoteModel>?,
    var count: Int?
)
