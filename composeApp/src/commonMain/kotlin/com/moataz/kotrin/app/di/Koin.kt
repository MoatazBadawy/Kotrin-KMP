package com.moataz.kotrin.app.di

import com.moataz.kotrin.features.home.data.KotrinApi
import com.moataz.kotrin.features.home.data.KotrinRepository
import com.moataz.kotrin.features.home.data.KtorKotrinApi
import com.moataz.kotrin.features.home.ui.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = ContentType.Any)
            }
        }
    }

    single<KotrinApi> { KtorKotrinApi(get()) }
    single {
        KotrinRepository(get())
    }
}

val viewModelModule = module {
    factoryOf(::HomeViewModel)
}

fun initKoin() {
    startKoin {
        modules(
            dataModule,
            viewModelModule,
        )
    }
}