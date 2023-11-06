package com.example.ketevan_mdzinarishvili_6

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ReqResService {
        @GET("unknown")
        fun getResources(@Query("page") page: Int): Call<Data<List<Resource>>>

        @GET("unknown/{resourceId}")
        fun getResourceById(@Path("resourceId") resourceId: Long): Call<Data<Resource>>
}