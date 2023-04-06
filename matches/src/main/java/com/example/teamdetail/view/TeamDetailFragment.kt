package com.example.teamdetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.matches.R
import com.example.matches.databinding.FragmentTeamDetailBinding
import com.example.matches.data.models.Matches
import com.example.teamdetail.data.models.PlayerDetail
import com.example.teamdetail.view.action.TeamsAction
import com.example.teamdetail.view.adapter.Team2DetailAdapter
import com.example.teamdetail.view.adapter.TeamDetailAdapter
import com.example.utils.core.BaseFragment
import com.example.utils.view.load
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentTeamDetailBinding
    private lateinit var teamDetailAdapter: TeamDetailAdapter
    private lateinit var team2DetailAdapter: Team2DetailAdapter
    private val match: Matches? by lazy {
        arguments?.getSerializable("match") as? Matches
    }
    private val viewModel: TeamDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = getDataBinding(inflater, container, R.layout.fragment_team_detail)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgOpponent1.load(match?.opponents?.first()?.opponent?.imageUrl ?: "", com.example.utils.R.drawable.place_holder)
        binding.imgOpponent2.load(match?.opponents?.get(1)?.opponent?.imageUrl ?: "", com.example.utils.R.drawable.place_holder)
        binding.titleOpponent1.text=match?.opponents?.first()?.opponent?.name
        binding.titleOpponent2.text=match?.opponents?.get(1)?.opponent?.name
        binding.titleTeamLeague.text=match?.league?.name
        binding.txtTeamHour.text=match?.scheduledAt
        observeActions()
    }

    private fun observeActions() {
        viewModel.teamsAction.observe(viewLifecycleOwner) {
            when (it) {
                is TeamsAction.TeamsLoaded -> setAdapters(it.playerDetail,it.player2Detail)

                is TeamsAction.Error -> showError(it.msg ?: "Generic Error")
            }
        }
    }

    private fun setAdapters(playerDetail: List<PlayerDetail>?, players2Detail: List<PlayerDetail>?) {
        teamDetailAdapter = TeamDetailAdapter()
        team2DetailAdapter = Team2DetailAdapter()
        teamDetailAdapter.players = playerDetail
        team2DetailAdapter.players = players2Detail
        binding.recyclerTeamDetail.adapter = teamDetailAdapter
        binding.recyclerTeam2Detail.adapter = team2DetailAdapter

    }


    private fun showError(error: String) =
        Toast.makeText(context, error, Toast.LENGTH_SHORT)
            .show()
}