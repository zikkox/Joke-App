package com.example.jokester.data.repository

import com.example.jokester.data.remote.RetrofitInstance
import com.example.jokester.data.toJoke
import com.example.jokester.domain.model.Joke
import com.example.jokester.domain.repository.JokesRepository
import retrofit2.Response

class JokesRepositoryImpl() : JokesRepository {

    private val jokeService = RetrofitInstance.createRetrofit()
        .create(com.example.jokester.data.remote.service.JokeService::class.java)

    override suspend fun getJoke(): Response<Joke> {
        val response = jokeService.getJoke()
        return if (response.isSuccessful && response.body() != null) {
            Response.success(response.body()!!.toJoke())
        } else {
            Response.error(response.code(), response.errorBody()!!)
        }
    }}