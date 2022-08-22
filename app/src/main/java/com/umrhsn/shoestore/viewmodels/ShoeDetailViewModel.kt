package com.umrhsn.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umrhsn.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {
    val shoeName = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeSize = MutableLiveData<Int>()
    val shoeDescription = MutableLiveData<String>()

//    private val _shoeName = MutableLiveData<String>()
//    private val _shoeCompany = MutableLiveData<String>()
//    private val _shoeSize = MutableLiveData<Int>()
//    private val _shoeDescription = MutableLiveData<String>()

//    val shoeName: LiveData<String> get() = _shoeName
//    val shoeCompany: LiveData<String> get() = _shoeCompany
//    val shoeSize: LiveData<Int> get() = _shoeSize
//    val shoeDescription: LiveData<String> get() = _shoeDescription

    // TODO: validate fields

    fun saveShoeData(): Shoe {
        return Shoe(
            shoeName.value ?: "",
            shoeSize.value ?: 0,
            shoeCompany.value ?: "",
            shoeDescription.value ?: "",
        )
    }
}