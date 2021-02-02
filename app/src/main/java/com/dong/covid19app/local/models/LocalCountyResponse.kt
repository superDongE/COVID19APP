package com.dong.covid19app.local.models

import com.google.gson.annotations.SerializedName

data class LocalCountyResponse(
        @SerializedName("countryName") val countryName: String,
        @SerializedName("newCase") val newCase: String,
        @SerializedName("totalCase") val totalCase: String,
        @SerializedName("recovered") val recovered: String,
        @SerializedName("death") val death: String,
        @SerializedName("percentage") val percentage: String,
        @SerializedName("newFcase") val newFcase: String,
        @SerializedName("newCcas") val newCcas: String
)
