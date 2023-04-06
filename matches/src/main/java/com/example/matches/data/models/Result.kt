package com.example.matches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("score")
    @Expose
    var score: Int? = null

    @SerializedName("team_id")
    @Expose
    var teamId: Int? = null
}