package com.fifa20companion.fifa20companion.api

import com.fifa20companion.fifa20companion.modulers.Player
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequests {

    @GET("searchPlayers/find")
    fun getAllPlayers(@Query("lName") name:String,
                      @Query("minOverall") overallMin:Int,
                      @Query("maxOverall") overallMax:Int,
                      @Query("minAge") ageMin:Int,
                      @Query("maxAge") ageMax:Int,
                      @Query("position") position: String
                      ):Call<Array<Player>>

    @GET("J1d9-9")
    fun getPlayer():Call<Player>

}