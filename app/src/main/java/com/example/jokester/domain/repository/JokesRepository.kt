package com.example.jokester.domain.repository

import com.example.jokester.domain.model.Joke
import retrofit2.Response

interface JokesRepository {
    suspend fun getJoke(): Response<Joke>
}