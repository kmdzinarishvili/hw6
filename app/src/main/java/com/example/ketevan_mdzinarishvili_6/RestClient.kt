package com.example.ketevan_mdzinarishvili_6

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    public val reqResService:ReqResService
        get() = getRetrofitClient().create(ReqResService::class.java)

}