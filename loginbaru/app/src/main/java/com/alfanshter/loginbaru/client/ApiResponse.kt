package com.alfanshter.loginbaru.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiResponse {

    val url = "http://192.168.1.13/login/"
    fun response():ApiClient
    {
        val retrofit = Retrofit.Builder().
            baseUrl(url).
            addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(ApiClient::class.java)

    }


}
