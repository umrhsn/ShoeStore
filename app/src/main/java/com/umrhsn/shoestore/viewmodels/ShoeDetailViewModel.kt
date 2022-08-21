package com.umrhsn.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umrhsn.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {
    private val _shoeName = MutableLiveData<String>()
    private val _shoeCompany = MutableLiveData<String>()
    private val _shoeSize = MutableLiveData<String>()
    private val _shoeDescription = MutableLiveData<String>()

    val shoeName: LiveData<String> get() = _shoeName
    val shoeCompany: LiveData<String> get() = _shoeCompany
    val shoeSize: LiveData<String> get() = _shoeSize
    val shoeDescription: LiveData<String> get() = _shoeDescription

    // TODO: validate fields

    fun saveShoeData(): Shoe {
        return Shoe(
            _shoeName.value ?: "",
            (_shoeSize.value ?: 0) as Int,
            _shoeCompany.value ?: "",
            _shoeDescription.value ?: "",
        )
    }
}