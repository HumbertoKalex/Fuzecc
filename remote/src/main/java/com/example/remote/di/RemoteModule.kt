package com.example.remote.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val TIMEOUT = 30L

fun createRemoteModule(
    mobileUrl: String,
): Module = module {

    single<Interceptor>(named("httpLoggingInterceptor")) {
        HttpLoggingInterceptor()
            .setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
    }

    single(named("mobileOkHttpClient")) {
        OkHttpClient
            .Builder().apply {
                connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                readTimeout(TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            }
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer ${"-ATCA_1Xhp3vLcDNbFXzaO38u9nhrwUjszV7XDRRkwVYpsh5vpk"}"
                    )
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    single(named("mobileRetrofit")) {
        configRetrofit(
            client = get(named("mobileOkHttpClient")),
            baseUrl = mobileUrl
        )
    }

}

private fun configRetrofit(client: OkHttpClient, baseUrl: String): Retrofit = Retrofit
    .Builder()
    .client(client)
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()