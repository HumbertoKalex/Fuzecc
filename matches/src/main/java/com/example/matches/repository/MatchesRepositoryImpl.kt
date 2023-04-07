package com.example.matches.repository

import com.example.matches.data.models.Matches

class MatchesRepositoryImpl(
    private val matchesService: MatchesApi
) : MatchesRepository {

    override suspend fun fetchMatches(): List<Matches> = matchesService.getMatches()

}