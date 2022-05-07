package com.fifa20companion.fifa20companion.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitServer {


    private const val BASE_URL =
        "http://10.0.2.2:3000/"
    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .build()
        .create(ApiRequests::class.java)

    fun getRetrofitApi(): ApiRequests? {
        return retrofit
    }
}