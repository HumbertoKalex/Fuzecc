package com.example.teamdetail.domain

import com.example.matches.data.models.Matches
import com.example.matches.data.models.Status
import com.example.matches.repository.MatchesRepository
import com.example.teamdetail.data.models.Team
import com.example.teamdetail.repository.TeamDetailRepository

class TeamDetailUseCaseImpl(
    private val teamDetailRepository: TeamDetailRepository
): TeamDetailUseCase {

    override suspend fun fetchTeam(name: String): Team =
        teamDetailRepository.fetchTeam(name)

}