package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe
    init {
        _shoeList.value = mutableListOf()
    }

    val shoeList: LiveData<MutableList<Shoe>> = _shoeList

    fun addShoe() {
        if (shoe.value != null) {
            _shoeList.value!!.add(shoe.value!!)
            _shoeList.value = mutableListOf<Shoe>().apply { addAll(_shoeList.value!!) }
        }
    }

     fun hasEmptyInput(): Boolean {
        if (shoe.value == null) return true;
        return shoe.value!!.name.isBlank()
                || shoe.value!!.company.isBlank()
                || shoe.value!!.description.isBlank()
                || shoe.value!!.size == 0
    }

    fun resetShoeValue(){
        _shoe.value = Shoe("", 0, "", "")
    }
    fun removeAll() {
        _shoeList.value = mutableListOf()
    }
}