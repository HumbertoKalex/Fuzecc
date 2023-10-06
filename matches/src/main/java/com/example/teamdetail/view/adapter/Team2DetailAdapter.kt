package com.example.teamdetail.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.matches.databinding.AdapterTeam2DetailBinding
import com.example.teamdetail.data.models.PlayerDetail
import com.example.utils.R
import com.example.utils.view.load

class Team2DetailAdapter : RecyclerView.Adapter<Team2DetailAdapter.ViewHolder>() {

    private var players: List<PlayerDetail> = listOf()

    fun updatePlayers(newPlayers: List<PlayerDetail>) {
        players = newPlayers
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: AdapterTeam2DetailBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(player: PlayerDetail) = with(binding) {
            playerDetail = player
            imgPlayer.load(player.imageUrl ?: "", com.example.matches.R.drawable.place_cs)
            executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTeam2DetailBinding.inflate(inflater, parent, false)
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
