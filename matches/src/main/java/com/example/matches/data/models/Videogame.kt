package com.example.matches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Videogame {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null
}