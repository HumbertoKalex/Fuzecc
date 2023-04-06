package com.example.teamdetail.repository

import com.example.teamdetail.data.models.Team
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamDetailApi {

    @GET("/teams")
    suspend fun getTeam(@Query("search[name]") name: String): Team

}