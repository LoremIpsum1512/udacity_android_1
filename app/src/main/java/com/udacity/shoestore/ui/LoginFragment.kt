package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.singInButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.signUpButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        return binding.root
    }
}