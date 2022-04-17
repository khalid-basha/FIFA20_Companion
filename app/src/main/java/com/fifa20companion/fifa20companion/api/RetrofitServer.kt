package com.fifa20companion.fifa20companion.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitServer {


    private const val BASE_URL =
        "https://api.jsonserve.com/uXfvKO/"
    private val retrofit = Retrofit.Builder()


        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiRequests::class.java)

    fun getAllPlayers(): Call<Player> {
        return retrofit.getAllPlayers()
    }
}