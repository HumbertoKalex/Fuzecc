package com.example.teamdetail.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Team {
    @SerializedName("acronym")
    @Expose
    var acronym: String? = null

    @SerializedName("current_videogame")
    @Expose
    var currentVideogame: CurrentVideogame? = null

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

    @SerializedName("players")
    @Expose
    var players: List<PlayerDetail>? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null
}

class CurrentVideogame {
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