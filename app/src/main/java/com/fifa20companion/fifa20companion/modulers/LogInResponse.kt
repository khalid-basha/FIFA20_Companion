package com.fifa20companion.fifa20companion.modulers

import com.google.gson.annotations.SerializedName

data class LogInResponse(
    @SerializedName("email") var email: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("password") var password: String? = null
)
