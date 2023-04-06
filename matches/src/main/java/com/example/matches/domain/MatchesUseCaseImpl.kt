package com.example.matches.domain

import com.example.matches.data.models.Matches
import com.example.matches.data.models.Status
import com.example.matches.repository.MatchesRepository

class MatchesUseCaseImpl(
    private val matchesRepository: MatchesRepository
): MatchesUseCase {

    override suspend fun fetchMatches(): List<Matches> =
        matchesRepository.fetchMatches()

    override suspend fun fetchMatchesByLive(): List<Matches> {
        return matchesRepository.fetchMatches().sortedBy {
            it.status==Status.RUNNING.name
        }
    }
}