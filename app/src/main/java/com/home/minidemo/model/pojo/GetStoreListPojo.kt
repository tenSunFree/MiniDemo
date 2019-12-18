package com.home.minidemo.model.pojo

import com.google.gson.annotations.SerializedName

data class GetStoreListPojo(
    val state: String = "",
    @SerializedName("store")
    val store: List<Store>? = null
) {
    data class Store(
        @SerializedName("imageUrl")
        val imageUrl: String? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("address")
        val address: String? = null,
        @SerializedName("phone")
        val phone: String? = null,
        @SerializedName("businessHours")
        val businessHours: String?
    )
}