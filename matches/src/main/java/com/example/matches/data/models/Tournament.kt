package com.example.matches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Tournament {
    @SerializedName("begin_at")
    @Expose
    var beginAt: String? = null

    @SerializedName("end_at")
    @Expose
    var endAt: String? = null

    @SerializedName("has_bracket")
    @Expose
    var hasBracket: Boolean? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("league_id")
    @Expose
    var leagueId: Int? = null

    @SerializedName("live_supported")
    @Expose
    var liveSupported: Boolean? = null

    @SerializedName("modified_at")
    @Expose
    var modifiedAt: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("prizepool")
    @Expose
    var prizepool: String? = null

    @SerializedName("serie_id")
    @Expose
    var serieId: Int? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("tier")
    @Expose
    var tier: String? = null

    @SerializedName("winner_id")
    @Expose
    var winnerId: String? = null

    @SerializedName("winner_type")
    @Expose
    var winnerType: String? = null
}