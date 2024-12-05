package com.example.jokester.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.R
import com.example.jokester.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: JokeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchRandomJoke()
        bindJoke()
        clickListeners()
    }

    private fun bindJoke() {
        lifecycleScope.launch {
            viewModel.joke.collect { joke ->
                joke?.let {
                    binding.setupText.text = it.setup
                    binding.punchlineText.text = it.punchline
                }
            }
        }
        lifecycleScope.launch {
            viewModel.error.collect { error ->
                error?.let {
                    Log.d("Error", "failed to get joke")
                }
            }
        }
    }

    private fun clickListeners() {
        with(binding) {
            nextButton.setOnClickListener {
                viewModel.fetchRandomJoke()
            }
            savesButton.setOnClickListener{
                findNavController().navigate(com.example.jokester.R.id.action_HomeToSaves)
            }
            saveButton.setOnClickListener{

            }
        }
    }
}