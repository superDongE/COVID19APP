package com.example.covid19app.home.models

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("NowCase") val NowCase: String,
    @SerializedName("TodayDeath") val TodayDeath: String,
    @SerializedName("TodayRecovered") val TodayRecovered: String,
    @SerializedName("TotalCase") val TotalCase: String,
    @SerializedName("TotalCaseBefore") val TotalCaseBefore: String,
    @SerializedName("TotalChecking") val TotalChecking: String,
    @SerializedName("TotalDeath") val TotalDeath: String,
    @SerializedName("TotalRecovered") val TotalRecovered: String,
    @SerializedName("caseCount") val caseCount: String,
    @SerializedName("casePercentage") val casePercentage: String,
    @SerializedName("checkingCounter") val checkingCounter: String,
    @SerializedName("checkingPercentage") val checkingPercentage: String,
    @SerializedName("city1n") val city1n: String,
    @SerializedName("city1p") val city1p: String,
    @SerializedName("city2n") val city2n: String,
    @SerializedName("city2p") val city2p: String,
    @SerializedName("city3n") val city3n: String,
    @SerializedName("city3p") val city3p: String,
    @SerializedName("city4n") val city4n: String,
    @SerializedName("city4p") val city4p: String,
    @SerializedName("city5n") val city5n: String,
    @SerializedName("city5p") val city5p: String,
    @SerializedName("deathPercentage") val deathPercentage: Double,
    @SerializedName("notcaseCount") val notcaseCount: String,
    @SerializedName("notcasePercentage") val notcasePercentage: String,
    @SerializedName("recoveredPercentage") val recoveredPercentage: Double,
    @SerializedName("resultCode") val resultCode: String,
    @SerializedName("resultMessage") val resultMessage: String,
    @SerializedName("updateTime") val updateTime: String
)