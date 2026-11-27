package com.mateju.frontend.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual fun createHttpClient(): HttpClient = HttpClient(Js) {
    install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
}

/** Must be replaced with the Railway HTTPS domain when it is generated. */
actual fun backendBaseUrl(): String = "https://mateju-backend-production.up.railway.app"
