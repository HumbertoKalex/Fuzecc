package com.example.teamdetail.domain

import com.example.teamdetail.data.models.Team

interface TeamDetailUseCase {

    suspend fun fetchTeam(name: String): Team

}