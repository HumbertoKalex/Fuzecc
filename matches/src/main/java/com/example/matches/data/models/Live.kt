package com.example.matches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Live {
    @SerializedName("opens_at")
    @Expose
    var opensAt: String? = null

    @SerializedName("supported")
    @Expose
    var supported: Boolean? = null

    @SerializedName("url")
    @Expose
    var url: String? = null
}