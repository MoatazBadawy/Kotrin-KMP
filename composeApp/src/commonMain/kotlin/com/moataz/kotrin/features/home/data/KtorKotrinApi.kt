package com.moataz.kotrin.features.home.data

import com.moataz.kotrin.features.home.data.entites.KotrinObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.cancellation.CancellationException

interface KotrinApi {
    suspend fun getData(): KotrinObject
}

class KtorKotrinApi(private val client: HttpClient) : KotrinApi {
    companion object {
        private const val API_URL =
            "https://moatazbadawy.github.io/kotrin.json"
    }

    override suspend fun getData(): KotrinObject {
        return try {
            client.get(API_URL).body()
        } catch (e: Exception) {
            throw CancellationException("Failed to fetch data")
        }
    }
}