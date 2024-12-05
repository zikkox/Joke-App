package com.example.jokester.data

import com.example.jokester.data.remote.dto.JokeDto
import com.example.jokester.domain.model.Joke

fun JokeDto.toJoke() =
    Joke(type = type, setup = setup, punchline = punchline, id = id)