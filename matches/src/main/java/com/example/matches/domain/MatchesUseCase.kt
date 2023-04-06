package com.example.matches.domain

import com.example.matches.data.models.Matches

interface MatchesUseCase {

    suspend fun fetchMatches(): List<Matches>

    suspend fun fetchMatchesByLive(): List<Matches>

}