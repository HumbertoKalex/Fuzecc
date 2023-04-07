package com.example.teamdetail.view.action

import com.example.teamdetail.data.models.PlayerDetail

sealed class TeamsAction {
    data class TeamsLoaded(val playerDetail: List<PlayerDetail>?, val player2Detail: List<PlayerDetail>?) :
        TeamsAction()

    data class Error(val msg: String? = null) : TeamsAction()
}
