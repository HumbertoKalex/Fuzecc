package com.example.teamdetail.repository

import com.example.teamdetail.data.models.Team

class TeamDetailRepositoryImpl(
    private val temDetailService: TeamDetailApi
) : TeamDetailRepository {

    override suspend fun fetchTeam(name: String): List<Team> = temDetailService.getTeam(name)

}