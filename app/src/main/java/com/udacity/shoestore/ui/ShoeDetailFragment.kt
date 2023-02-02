package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailBinding.inflate(layoutInflater)
        viewModel.resetShoeValue()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.cancelButton.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.saveButton.setOnClickListener {
            if (viewModel.hasEmptyInput()) Toast.makeText(
                context,
                "Some inputs are missing, please check again",
                Toast.LENGTH_SHORT
            ).show()
            else {
                viewModel.addShoe()
                findNavController().navigateUp()
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.resetShoeValue()
    }

}