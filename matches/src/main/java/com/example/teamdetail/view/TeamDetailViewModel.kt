package com.example.teamdetail.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remote.SafeResponse
import com.example.remote.safeRequest
import com.example.teamdetail.data.models.Team
import com.example.teamdetail.domain.TeamDetailUseCase
import com.example.teamdetail.view.action.TeamsAction
import kotlinx.coroutines.launch

class TeamDetailViewModel(
    private val teamDetailUseCase: TeamDetailUseCase
) : ViewModel() {

    var teamsAction = MutableLiveData<TeamsAction>()

    fun fetchTeam(name: String, name2: String) {
        viewModelScope.launch {
            when (val response = safeRequest { teamDetailUseCase.fetchTeam(name) }) {
                is SafeResponse.Success -> {
                    fetchTeam2(response.value.first(), name2)
                    Log.d("Teste","teste")
                }

                is SafeResponse.GenericError -> TeamsAction.Error(response.errorBody?.error).run()
                is SafeResponse.NetworkError -> TeamsAction.Error().run()
            }
        }
    }

    private fun fetchTeam2(team1: Team, name: String) {
        viewModelScope.launch {
            when (val response = safeRequest { teamDetailUseCase.fetchTeam(name) }) {
                is SafeResponse.Success -> {
                    TeamsAction.TeamsLoaded(
                        team1.players ?: listOf(),
                        response.value.first().players ?: listOf()
                    ).run()
                    Log.d("Teste","teste")
                }

                is SafeResponse.GenericError -> TeamsAction.Error(response.errorBody?.error).run()
                is SafeResponse.NetworkError -> TeamsAction.Error().run()
            }
        }
    }

    private fun TeamsAction.run() = teamsAction.postValue(this)

}