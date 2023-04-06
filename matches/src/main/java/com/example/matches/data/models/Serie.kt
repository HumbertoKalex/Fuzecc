package com.example.matches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Serie {
    @SerializedName("begin_at")
    @Expose
    var beginAt: String? = null

    @SerializedName("end_at")
    @Expose
    var endAt: String? = null

    @SerializedName("full_name")
    @Expose
    var fullName: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("league_id")
    @Expose
    var leagueId: Int? = null

    @SerializedName("modified_at")
    @Expose
    var modifiedAt: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("season")
    @Expose
    var season: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("winner_id")
    @Expose
    var winnerId: String? = null

    @SerializedName("winner_type")
    @Expose
    var winnerType: String? = null

    @SerializedName("year")
    @Expose
    var year: Int? = null
}