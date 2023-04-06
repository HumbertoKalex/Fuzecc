package com.example.matches.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Matches: java.io.Serializable {
    @SerializedName("begin_at")
    @Expose
    var beginAt: String? = null

    @SerializedName("detailed_stats")
    @Expose
    var detailedStats: Boolean? = null

    @SerializedName("draw")
    @Expose
    var draw: Boolean? = null

    @SerializedName("end_at")
    @Expose
    var endAt: String? = null

    @SerializedName("forfeit")
    @Expose
    var forfeit: Boolean? = null

    @SerializedName("game_advantage")
    @Expose
    var gameAdvantage: String? = null

    @SerializedName("games")
    @Expose
    var games: List<Game>? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("league")
    @Expose
    var league: League? = null

    @SerializedName("league_id")
    @Expose
    var leagueId: Int? = null

    @SerializedName("live")
    @Expose
    var live: Live? = null

    @SerializedName("match_type")
    @Expose
    var matchType: String? = null

    @SerializedName("modified_at")
    @Expose
    var modifiedAt: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("number_of_games")
    @Expose
    var numberOfGames: Int? = null

    @SerializedName("opponents")
    @Expose
    var opponents: List<Opponent>? = null

    @SerializedName("original_scheduled_at")
    @Expose
    var originalScheduledAt: String? = null

    @SerializedName("rescheduled")
    @Expose
    var rescheduled: Boolean? = null

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null

    @SerializedName("scheduled_at")
    @Expose
    var scheduledAt: String? = null

    @SerializedName("serie")
    @Expose
    var serie: Serie? = null

    @SerializedName("serie_id")
    @Expose
    var serieId: Int? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("streams_list")
    @Expose
    var streamsList: List<Streams>? = null

    @SerializedName("tournament")
    @Expose
    var tournament: Tournament? = null

    @SerializedName("tournament_id")
    @Expose
    var tournamentId: Int? = null

    @SerializedName("videogame")
    @Expose
    var videogame: Videogame? = null

    @SerializedName("videogame_version")
    @Expose
    var videogameVersion: String? = null

    @SerializedName("winner")
    @Expose
    var winnerDetail: WinnerDetail? = null

    @SerializedName("winner_id")
    @Expose
    var winnerId: Int? = null

    @SerializedName("winner_type")
    @Expose
    var winnerType: String? = null
}

enum class Status(value: String){
    FINISHED("finished"),
    NOT_PLAYED("not_played"),
    NOT_STARTED("not_started"),
    RUNNING("running")
}