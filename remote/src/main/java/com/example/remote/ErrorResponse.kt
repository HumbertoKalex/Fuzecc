package com.example.remote

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("error") val error: String? = null
)