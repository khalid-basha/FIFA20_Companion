package com.fifa20companion.fifa20companion.api

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequests {

    @GET("/")
    fun getAllPlayers():Call<Player>
}