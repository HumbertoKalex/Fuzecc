package com.example.teamdetail.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlayerDetail {
    @SerializedName("age")
    @Expose
    var age: Int? = null

    @SerializedName("birthday")
    @Expose
    var birthday: String? = null

    @SerializedName("first_name")
    @Expose
    var firstName: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null

    @SerializedName("last_name")
    @Expose
    var lastName: String? = null

    @SerializedName("modified_at")
    @Expose
    var modifiedAt: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("nationality")
    @Expose
    var nationality: String? = null

    @SerializedName("role")
    @Expose
    var role: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null
}