package com.example.matches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Streams {
    @SerializedName("embed_url")
    @Expose
    var embedUrl: String? = null

    @SerializedName("language")
    @Expose
    var language: String? = null

    @SerializedName("main")
    @Expose
    var main: Boolean? = null

    @SerializedName("official")
    @Expose
    var official: Boolean? = null

    @SerializedName("raw_url")
    @Expose
    var rawUrl: String? = null
}