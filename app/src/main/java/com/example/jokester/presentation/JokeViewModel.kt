package com.example.jokester.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.jokester.data.repository.JokesRepositoryImpl
import com.example.jokester.domain.model.Joke
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {

    private val repository = JokesRepositoryImpl()

    private val _joke = MutableStateFlow<Joke?>(null)
    val joke: StateFlow<Joke?> = _joke

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchRandomJoke() {
        viewModelScope.launch {
            val response = repository.getJoke()
            if (response.isSuccessful) {
                _joke.value = response.body()
            } else {
                _error.value = "Failed to fetch joke: ${response.code()}"
            }
        }
    }
}