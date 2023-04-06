package com.example.matches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class League {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null

    @SerializedName("modified_at")
    @Expose
    var modifiedAt: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null
}