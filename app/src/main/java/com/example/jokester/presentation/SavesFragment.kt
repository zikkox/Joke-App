package com.example.jokester.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.jokester.data.repository.JokesRepositoryImpl
import com.example.jokester.databinding.FragmentHomeBinding
import com.example.jokester.databinding.FragmentSavesBinding

class SavesFragment : Fragment() {
    private lateinit var binding: FragmentSavesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickListeners()
    }

    private fun clickListeners(){
        binding.homeButton.setOnClickListener{
            findNavController().navigate(com.example.jokester.R.id.action_SavesToHome)
        }
    }
}