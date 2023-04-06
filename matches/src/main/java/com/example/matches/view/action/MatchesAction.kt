package com.example.matches.view.action

import com.example.matches.data.models.Matches

sealed class MatchesAction {
    data class MatchesLoaded(val matches: List<Matches>) : MatchesAction()
    data class Error(val msg: String? = null) : MatchesAction()
}
