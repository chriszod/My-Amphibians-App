package com.example.myamphibiansapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myamphibiansapp.R
import com.example.myamphibiansapp.databinding.FragmentAmphibiansListBinding

class AmphibiansListFragment : Fragment() {

    private val viewModel: AmphibiansViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentAmphibiansListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = AmphibianListAdapter(AmphibianListener { amphibian -> viewModel.onAmphibianClicked(amphibian)
            findNavController().navigate(R.id.action_amphibiansListFragment_to_amphibiansDetailFragment)
        })

        return binding.root
    }

}