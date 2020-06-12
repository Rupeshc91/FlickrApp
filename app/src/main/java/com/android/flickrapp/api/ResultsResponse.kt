package com.elifox.legocatalog.api

import com.google.gson.annotations.SerializedName

data class ResultsResponse<T>(
    @SerializedName("total")
    val total: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("pages")
    val pages:Int,
    @SerializedName("photo")
    val result: List<T>
)