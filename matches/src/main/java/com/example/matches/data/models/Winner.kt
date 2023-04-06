package com.example.matches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Winner {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("type")
    @Expose
    var type: String? = null
}

class WinnerDetail {
    @SerializedName("acronym")
    @Expose
    var acronym: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null

    @SerializedName("location")
    @Expose
    var location: String? = null

    @SerializedName("modified_at")
    @Expose
    var modifiedAt: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null
}