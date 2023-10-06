package com.example.teamdetail.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.matches.databinding.AdapterTeamDetailBinding
import com.example.teamdetail.data.models.PlayerDetail
import com.example.utils.R
import com.example.utils.view.load

class TeamDetailAdapter : RecyclerView.Adapter<TeamDetailAdapter.ViewHolder>() {

    private var players: List<PlayerDetail> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun updatePlayers(newPlayers: List<PlayerDetail>) {
        players = newPlayers
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: AdapterTeamDetailBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(player: PlayerDetail) = with(binding) {
            playerDetail = player
            imgPlayer.load(player.imageUrl ?: "", com.example.matches.R.drawable.place_cs)
            executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTeamDetailBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        players[position].let {
            holder.bind(it)

            // Apply the animation
            val animation = AnimationUtils.loadAnimation(holder.itemView.context, com.example.matches.R.anim.item_slide_in)
            holder.itemView.startAnimation(animation)
        }
    }

    override fun getItemCount(): Int = players.size
}
