package com.example.teamdetail.domain

import com.example.teamdetail.data.models.Team
import com.example.teamdetail.repository.TeamDetailRepository

class TeamDetailUseCaseImpl(
    private val teamDetailRepository: TeamDetailRepository
) : TeamDetailUseCase {

    override suspend fun fetchTeam(name: String): List<Team> =
        teamDetailRepository.fetchTeam(name)

}