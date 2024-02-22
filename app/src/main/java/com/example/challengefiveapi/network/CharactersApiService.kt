package com.example.challengefiveapi.network
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://rickandmortyapi.com"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CharactersApiService {
    @GET("api/character")
    suspend fun getCharacterData(): String
}

object CharactersApi {
    val retrofitService : CharactersApiService by lazy {
        retrofit.create(CharactersApiService::class.java)
    }
}
