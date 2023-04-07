package com.example.matches.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.matches.data.models.Matches
import com.example.matches.data.models.Status
import com.example.matches.databinding.AdapterMatchesBinding
import com.example.utils.R
import com.example.utils.view.convertToCurrentTimezone
import com.example.utils.view.load

typealias ClickableCallback = (match: Matches) -> Unit

class MatchesAdapter(val callback: ClickableCallback) : RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {

    var matches: List<Matches>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(private val binding: AdapterMatchesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Matches) = with(binding) {
            match = item

            imgOpponent1.load(item.opponents?.firstOrNull()?.opponent?.imageUrl ?: "", R.drawable.place_holder)
            imgOpponent2.load(item.opponents?.getOrNull(1)?.opponent?.imageUrl ?: "", R.drawable.place_holder)
            imgLeague.load(item.league?.imageUrl ?: "", R.drawable.place_holder)
            if (item.status.equals(Status.RUNNING.name)) {
                binding.linearBadge.background =
                    binding.root.resources.getDrawable(com.example.matches.R.drawable.badge_red)
                binding.txtBadge.text = binding.root.context.getString(com.example.matches.R.string.agora)
            } else {
                binding.linearBadge.background =
                    binding.root.resources.getDrawable(com.example.matches.R.drawable.badge_grey)
                binding.txtBadge.text = item.scheduledAt?.convertToCurrentTimezone()
            }
            binding.constraintBook.setOnClickListener {
                callback.invoke(item)
            }
            executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMatchesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        matches?.get(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = matches?.size ?: 0
}