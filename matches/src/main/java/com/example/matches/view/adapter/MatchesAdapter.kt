package com.example.matches.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.matches.data.models.Matches
import com.example.matches.data.models.Status
import com.example.matches.databinding.AdapterMatchesBinding
import com.example.utils.R
import com.example.utils.view.convertToCurrentTimezone
import com.example.utils.view.load

typealias ClickableCallback = (match: Matches) -> Unit

class MatchesAdapter(private val callback: ClickableCallback) : RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {

    private var matches: List<Matches> = listOf()

    fun updateMatches(newMatches: List<Matches>) {
        matches = newMatches
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: AdapterMatchesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Matches) = binding.apply {
            match = item

            imgOpponent1.load(item.opponents?.firstOrNull()?.opponent?.imageUrl ?:"", com.example.matches.R.drawable.place_cs)
            imgOpponent2.load(item.opponents?.getOrNull(1)?.opponent?.imageUrl ?:"", com.example.matches.R.drawable.place_cs)
            imgLeague.load(item.league?.imageUrl ?:"", com.example.matches.R.drawable.place_cs)

            if (item.status == Status.RUNNING.name) {
                linearBadge.background = ContextCompat.getDrawable(root.context, com.example.matches.R.drawable.badge_red)
                txtBadge.text = root.context.getString(com.example.matches.R.string.agora)
            } else {
                linearBadge.background = ContextCompat.getDrawable(root.context, com.example.matches.R.drawable.badge_grey)
                txtBadge.text = item.scheduledAt?.convertToCurrentTimezone()
            }

            constraintBook.setOnClickListener { callback.invoke(item) }

            executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMatchesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(matches[position])
    }

    override fun getItemCount(): Int = matches.size
}
