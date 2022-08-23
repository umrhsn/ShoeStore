package com.umrhsn.shoestore.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umrhsn.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailViewModel : ViewModel() {
    val shoeName = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeSize = MutableLiveData<Int>()
    val shoeDescription = MutableLiveData<String>()

//    val shoeName: LiveData<String> get() = _shoeName
//    val shoeCompany: LiveData<String> get() = _shoeCompany
//    val shoeSize: LiveData<Int> get() = _shoeSize
//    val shoeDescription: LiveData<String> get() = _shoeDescription

    init {
        Timber.i("ShoeDetailViewModel init")
    }

    // TODO: validate fields

    fun saveShoeData(): Shoe {
        Timber.i("saveShoeData called")
        val shoe = Shoe(
            shoeName.value ?: "",
            shoeSize.value ?: 0,
            shoeCompany.value ?: "",
            shoeDescription.value ?: "",
        )
        Timber.i("_shoeName.value = ${shoeName.value}")
        Timber.i("_shoeSize.value = ${shoeSize.value}")
        Timber.i("_shoeCompany.value = ${shoeCompany.value}")
        Timber.i("_shoeDescription.value = ${shoeDescription.value}")
        return shoe
    }
}