package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe


class ShoeListingFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()
    private val binding by lazy {
        FragmentShoeListingBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            binding.linearLayout.removeAllViews()
            for (shoe in it) {
                val itemViewBinding = DataBindingUtil.inflate<ShoeItemBinding>(
                    inflater, R.layout.shoe_item, binding.linearLayout, false
                )
                itemViewBinding.shoe = shoe
                binding.linearLayout.addView(itemViewBinding.root)

            }
        })

        binding.fab.setOnClickListener {
            val rd = (0..1000).random()
            val shoe =
                Shoe(
                    name = "${rd}name",
                    size = 1.0,
                    company = "company",
                    description = "description"
                )
            viewModel.addShoe(shoe)
        }


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) ||
                super.onOptionsItemSelected(item)
    }
}