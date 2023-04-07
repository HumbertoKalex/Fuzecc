package com.example.matches.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matches.data.models.Matches
import com.example.matches.domain.MatchesUseCase
import com.example.matches.view.action.MatchesAction
import com.example.remote.SafeResponse
import com.example.remote.safeRequest
import kotlinx.coroutines.launch

class MatchesViewModel(
    private val matchesUseCase: MatchesUseCase
) : ViewModel() {

    var matchesAction = MutableLiveData<MatchesAction>()
    var match = MutableLiveData<List<Matches>>()

    fun fetchMatchesByLive() {
        viewModelScope.launch {
            when (val response = safeRequest { matchesUseCase.fetchMatchesByLive() }) {
                is SafeResponse.Success -> {
                    MatchesAction.MatchesLoaded(response.value).run()
                }
                is SafeResponse.GenericError -> MatchesAction.Error(response.errorBody?.error).run()
                is SafeResponse.NetworkError -> MatchesAction.Error().run()
                else -> {}
            }
        }
    }

    private fun MatchesAction.run() = matchesAction.postValue(this)

}