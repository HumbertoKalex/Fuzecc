package com.example.teamdetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.matches.R
import com.example.matches.data.models.Matches
import com.example.matches.databinding.FragmentTeamDetailBinding
import com.example.teamdetail.view.action.TeamsAction
import com.example.teamdetail.view.adapter.Team2DetailAdapter
import com.example.teamdetail.view.adapter.TeamDetailAdapter
import com.example.utils.core.BaseFragment
import com.example.utils.view.convertToCurrentTimezone
import com.example.utils.view.load
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentTeamDetailBinding
    private val teamDetailAdapter by lazy { TeamDetailAdapter() }
    private val team2DetailAdapter by lazy { Team2DetailAdapter() }
    private val match: Matches? by lazy {
        arguments?.getSerializable("match") as? Matches
    }
    private val viewModel: TeamDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = getDataBinding(inflater, container, R.layout.fragment_team_detail)
        setupRecyclerViews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        observeActions()
        viewModel.fetchTeam(
            match?.opponents?.firstOrNull()?.opponent?.name ?: "",
            match?.opponents?.getOrNull(1)?.opponent?.name ?: ""
        )
    }

    private fun setupUI() {
        binding.imgOpponent1.load(
            match?.opponents?.firstOrNull()?.opponent?.imageUrl ?: "",
            R.drawable.place_cs
        )
        binding.imgOpponent2.load(
            match?.opponents?.getOrNull(1)?.opponent?.imageUrl ?: "",
             R.drawable.place_cs
        )
        binding.titleOpponent1.text = match?.opponents?.firstOrNull()?.opponent?.name
        binding.titleOpponent2.text = match?.opponents?.getOrNull(1)?.opponent?.name
        binding.titleTeamLeague.text = match?.league?.name
        binding.txtTeamHour.text = match?.scheduledAt?.convertToCurrentTimezone()
    }

    private fun setupRecyclerViews() {
        binding.recyclerTeamDetail.adapter = teamDetailAdapter
        binding.recyclerTeam2Detail.adapter = team2DetailAdapter
    }

    private fun observeActions() {
        viewModel.teamsAction.observe(viewLifecycleOwner) {
            when (it) {
                is TeamsAction.TeamsLoaded -> {
                    teamDetailAdapter.updatePlayers(it.playerDetail)
                    team2DetailAdapter.updatePlayers(it.player2Detail)
                }
                is TeamsAction.Error -> showError(it.msg ?: "Generic Error")
            }
        }
    }

    private fun showError(error: String) =
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
}
