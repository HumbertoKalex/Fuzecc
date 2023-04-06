package com.example.matches.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.matches.databinding.AdapterMatchesBinding
import com.example.matches.data.models.Matches
import com.example.utils.R
import com.example.utils.view.load

typealias ClickableCallback = (match: Matches) -> Unit

class MatchesAdapter(val callback: ClickableCallback): RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {

    var matches: List<Matches>? = null
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: AdapterMatchesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Matches) = with(binding) {
            match = item
            imgOpponent1.load(item.opponents?.first()?.opponent?.imageUrl ?: "", R.drawable.place_holder)
            imgOpponent2.load(item.opponents?.get(1)?.opponent?.imageUrl ?: "",R.drawable.place_holder)
            imgLeague.load(item.league?.imageUrl ?: "",R.drawable.place_holder)
            binding.constraintBook.setOnClickListener {
                callback.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
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