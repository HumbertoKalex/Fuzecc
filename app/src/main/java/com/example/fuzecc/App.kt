package com.example.fuzecc

import com.example.matches.di.matchesModule
import com.example.remote.di.createRemoteModule
import com.example.teamdetail.di.teamDetailModule
import dagger.android.support.DaggerApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class App : DaggerApplication(){

    private val applicationInjector = DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    matchesModule,
                    teamDetailModule
                )
            )
        }
        loadKoinModules(
            listOf(
                createRemoteModule(
                    mobileUrl = "https://api.pandascore.co/csgo/")
            )
        )
    }

    override fun applicationInjector() = applicationInjector

}