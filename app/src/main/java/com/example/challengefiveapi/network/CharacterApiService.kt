package com.example.challengefiveapi.network

import com.example.challengefiveapi.model.ApiResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

    private const val BASE_URL = "https://rickandmortyapi.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    interface CharacterApiService {
        @GET("api/character")
        suspend fun getCharacters(): ApiResponse
    }

    object CharactersApi {
        val retrofitService: CharacterApiService by lazy {
            retrofit.create(CharacterApiService::class.java)
        }
}
