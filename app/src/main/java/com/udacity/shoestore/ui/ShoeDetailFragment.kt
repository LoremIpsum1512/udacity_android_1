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
        binding.cancelButton.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.saveButton.setOnClickListener {
            if (hasEmptyInput()) Toast.makeText(
                context,
                "Some inputs are missing, please check again",
                Toast.LENGTH_SHORT
            ).show()
            else {
                addShoe()
            }
        }
        return binding.root
    }

    private fun addShoe() {
        val shoe = Shoe(
            name = binding.nameInput.text.toString(),
            company = binding.companyInput.text.toString(),
            size =  binding.sizeInput.text.toString().toDouble(),
            description = binding.descriptionInput.text.toString()
        )
        viewModel.addShoe(shoe)
        findNavController().navigateUp()
    }

    private fun hasEmptyInput(): Boolean {
        return binding.nameInput.text.isEmpty()
                || binding.companyInput.text.isEmpty()
                || binding.sizeInput.text.isEmpty()
                || binding.descriptionInput.text.isEmpty()
    }

}