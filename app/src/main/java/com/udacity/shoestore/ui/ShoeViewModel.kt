package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        _shoeList.value = mutableListOf()
    }

    val shoeList: LiveData<MutableList<Shoe>> = _shoeList

    fun addShoe(shoe: Shoe) {
        _shoeList.value!!.add(shoe)
        _shoeList.value = mutableListOf<Shoe>().apply { addAll(_shoeList.value!!) }
    }

    fun removeAll() {
        _shoeList.value = mutableListOf()
    }
}