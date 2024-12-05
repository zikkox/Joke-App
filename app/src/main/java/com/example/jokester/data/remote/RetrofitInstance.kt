package com.example.jokester.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://official-joke-api.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}