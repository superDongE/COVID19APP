package com.dong.covid19app.local.models

import com.google.gson.annotations.SerializedName

data class LocalResponse(
        @SerializedName("busan") val busan: LocalCountyResponse,
        @SerializedName("chungbuk") val chungbuk: LocalCountyResponse,
        @SerializedName("chungnam") val chungnam: LocalCountyResponse,
        @SerializedName("daegu") val daegu: LocalCountyResponse,
        @SerializedName("daejeon") val daejeon: LocalCountyResponse,
        @SerializedName("gangwon") val gangwon: LocalCountyResponse,
        @SerializedName("gwangju") val gwangju: LocalCountyResponse,
        @SerializedName("gyeongbuk") val gyeongbuk: LocalCountyResponse,
        @SerializedName("gyeonggi") val gyeonggi: LocalCountyResponse,
        @SerializedName("gyeongnam") val gyeongnam: LocalCountyResponse,
        @SerializedName("incheon") val incheon: LocalCountyResponse,
        @SerializedName("jeju") val jeju: LocalCountyResponse,
        @SerializedName("jeonbuk") val jeonbuk: LocalCountyResponse,
        @SerializedName("jeonnam") val jeonnam: LocalCountyResponse,
        @SerializedName("korea") val korea: LocalCountyResponse,
        @SerializedName("quarantine") val quarantine: LocalCountyResponse,
        @SerializedName("resultCode") val resultCode: String,
        @SerializedName("resultMessage") val resultMessage: String,
        @SerializedName("sejong") val sejong: LocalCountyResponse,
        @SerializedName("seoul") val seoul: LocalCountyResponse,
        @SerializedName("ulsan") val ulsan: LocalCountyResponse
)