package com.example.matches.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.matches.R
import com.example.matches.data.models.Matches
import com.example.matches.databinding.FragmentMatchesBinding
import com.example.matches.view.action.MatchesAction
import com.example.matches.view.adapter.MatchesAdapter
import com.example.utils.core.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MatchesFragment : BaseFragment() {

    private lateinit var binding: FragmentMatchesBinding
    private lateinit var matchesAdapter: MatchesAdapter
    private val viewModel: MatchesViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = getDataBinding(inflater, container, R.layout.fragment_matches)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeActions()
        viewModel.fetchMatchesByLive()
    }

    private fun observeActions() {
        viewModel.matchesAction.observe(viewLifecycleOwner) {
            when (it) {
                is MatchesAction.MatchesLoaded -> setAdapter(it.matches)

                is MatchesAction.Error -> showError(it.msg ?: "Generic Error")
                else -> {}
            }
        }
    }

    private fun setAdapter(matches: List<Matches>) =
        matches.let {
            binding.progressMatches.visibility = View.GONE
            binding.recyclerMatches.visibility = View.VISIBLE
            matchesAdapter = MatchesAdapter {
                findNavController().navigate(
                    R.id.action_matchesFragment_to_teams_fragment,
                    bundleOf(
                        "match" to it
                    )
                )
            }
            matchesAdapter.matches = matches
            binding.recyclerMatches.adapter = matchesAdapter
        }

    private fun showError(error: String) =
        Toast.makeText(context, error, Toast.LENGTH_SHORT)
            .show()
}