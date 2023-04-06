package com.example.teamdetail.di

import com.example.matches.view.MatchesViewModel
import com.example.teamdetail.domain.TeamDetailUseCase
import com.example.teamdetail.domain.TeamDetailUseCaseImpl
import com.example.teamdetail.repository.TeamDetailApi
import com.example.teamdetail.repository.TeamDetailRepository
import com.example.teamdetail.repository.TeamDetailRepositoryImpl
import com.example.teamdetail.view.TeamDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val teamDetailModule = module {
    factory { get<Retrofit>(named("mobileRetrofit")).create(TeamDetailApi::class.java) }
    factory<TeamDetailRepository> { TeamDetailRepositoryImpl(get()) }
    factory<TeamDetailUseCase> { TeamDetailUseCaseImpl(get()) }

    viewModel { TeamDetailViewModel(get()) }
}