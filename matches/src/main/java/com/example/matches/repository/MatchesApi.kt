package com.example.matches.repository

import com.example.matches.data.models.Matches
import retrofit2.http.GET

interface MatchesApi {
    @GET("/matches")
    suspend fun getMatches(): List<Matches>
}