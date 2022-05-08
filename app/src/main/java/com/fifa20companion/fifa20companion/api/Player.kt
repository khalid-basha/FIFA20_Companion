package com.fifa20companion.fifa20companion.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable
data class Player (

    @SerializedName("id") var  id: Int? = null,
    @SerializedName("sName") var sName: String? = null,
    @SerializedName("lName") var lName: String? = null,
    @SerializedName("age") var age: Int? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("weight") var weight: Int? = null,
    @SerializedName("nation") var nation: String? = null,
    @SerializedName("club") var club: String? = null,
    @SerializedName("overall") var overall: Int? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("position") var position: String? = null,
    @SerializedName("foot") var foot: String? = null
): Serializable
