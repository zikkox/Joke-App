package com.example.jokester.data.remote.service

import com.example.jokester.data.remote.dto.JokeDto
import retrofit2.http.GET

interface JokeService {
    @GET("random_joke")
    suspend fun getJoke(): retrofit2.Response<JokeDto>

}