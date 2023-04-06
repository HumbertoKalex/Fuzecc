package com.example.teamdetail.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.matches.databinding.AdapterTeamDetailBinding
import com.example.teamdetail.data.models.PlayerDetail
import com.example.utils.R
import com.example.utils.view.load

class TeamDetailAdapter: RecyclerView.Adapter<TeamDetailAdapter.ViewHolder>() {

    var players: List<PlayerDetail>? = null
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: AdapterTeamDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(player: PlayerDetail) = with(binding) {
            playerDetail = player
            imgPlayer.load(player.imageUrl ?: "", R.drawable.place_holder_team)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTeamDetailBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        players?.get(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = players?.size ?: 5
}