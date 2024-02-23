package com.example.challengefiveapi.network
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

interface CharactersApiService {
    @GET("api/character")
    suspend fun getCharacterData(): ApiResponse
}

object CharactersApi {
    val retrofitService : CharactersApiService by lazy {
        retrofit.create(CharactersApiService::class.java)
    }
}
