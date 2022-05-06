package com.fifa20companion.fifa20companion.api

import com.fifa20companion.fifa20companion.modulers.Root
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequests {

    @GET("TDu_S2")
    fun getAllPlayers():Call<List<Player>>  //https://api.jsonserve.com/-99LbV

    @GET("J1d9-9")
    fun getPlayer():Call<Player>

}