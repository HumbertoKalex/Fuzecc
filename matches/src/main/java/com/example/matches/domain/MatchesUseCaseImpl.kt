package com.example.matches.domain

import com.example.matches.data.models.Matches
import com.example.matches.repository.MatchesRepository
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.math.abs

class MatchesUseCaseImpl(
    private val matchesRepository: MatchesRepository
) : MatchesUseCase {

    override suspend fun fetchMatches(): List<Matches> =
        matchesRepository.fetchMatches()

    override suspend fun fetchMatchesByLive(): List<Matches> =
        matchesRepository.fetchMatches().orderMatchesByDate()

    private fun List<Matches>.orderMatchesByDate(): List<Matches> {
        val currentDate = Calendar.getInstance()
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

        return this.sortedBy {
            val date = sdf.parse(it.scheduledAt ?: "")
            val calendar = Calendar.getInstance().apply { time = date }
            abs(calendar.timeInMillis - currentDate.timeInMillis)
        }
    }
}