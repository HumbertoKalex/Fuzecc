package com.example.matches.di

import com.example.matches.domain.MatchesUseCase
import com.example.matches.domain.MatchesUseCaseImpl
import com.example.matches.repository.MatchesApi
import com.example.matches.repository.MatchesRepository
import com.example.matches.repository.MatchesRepositoryImpl
import com.example.matches.view.MatchesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val matchesModule = module {
    factory { get<Retrofit>(named("mobileRetrofit")).create(MatchesApi::class.java) }
    factory<MatchesRepository> { MatchesRepositoryImpl(get()) }
    factory<MatchesUseCase> { MatchesUseCaseImpl(get()) }

    viewModel { MatchesViewModel(get()) }
}