package com.example.teamdetail.repository

import com.example.teamdetail.data.models.Team

interface TeamDetailRepository {

    suspend fun fetchTeam(name: String): List<Team>

}