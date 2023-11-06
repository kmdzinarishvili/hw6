package com.example.ketevan_mdzinarishvili_6

import com.google.gson.annotations.SerializedName

data class Data<T> (
    var page: Int?,
    @SerializedName("per_page")
    var perPage: Int?,
    var total: Int?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    var data: T
)

data class Resource (
    var id: Long?,
    var name: String?,
    var color: String?,
    var year: Int?,
    @SerializedName("pantone_value")
    var pantoneValue: String?
)