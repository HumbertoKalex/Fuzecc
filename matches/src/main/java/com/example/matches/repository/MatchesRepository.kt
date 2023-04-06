package com.example.matches.repository

import com.example.matches.data.models.Matches

interface MatchesRepository {

    suspend fun fetchMatches(): List<Matches>

}