package com.example.matches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Game {
    @SerializedName("begin_at")
    @Expose
    var beginAt: String? = null

    @SerializedName("complete")
    @Expose
    var complete: Boolean? = null

    @SerializedName("detailed_stats")
    @Expose
    var detailedStats: Boolean? = null

    @SerializedName("end_at")
    @Expose
    var endAt: String? = null

    @SerializedName("finished")
    @Expose
    var finished: Boolean? = null

    @SerializedName("forfeit")
    @Expose
    var forfeit: Boolean? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("length")
    @Expose
    var length: Int? = null

    @SerializedName("match_id")
    @Expose
    var matchId: Int? = null

    @SerializedName("position")
    @Expose
    var position: Int? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("winner")
    @Expose
    var winner: Winner? = null

    @SerializedName("winner_type")
    @Expose
    var winnerType: String? = null
}