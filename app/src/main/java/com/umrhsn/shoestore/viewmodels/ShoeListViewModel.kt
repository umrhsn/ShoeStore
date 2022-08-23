package com.umrhsn.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umrhsn.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    init {
        Timber.i("ShoeListViewModel init")
    }

    fun isListEmpty(): Boolean {
        Timber.i("isListEmpty called\n" + "_shoeList.value = ${_shoeList.value}")
        val isEmpty = _shoeList.value == null || _shoeList.value?.isEmpty() == true
        Timber.i("isEmpty = $isEmpty")
        return isEmpty
    }

    fun addShoe(shoe: Shoe) {
        Timber.i("addShoe called\n" + "shoe = $shoe\n" + "_shoeList.value = $shoe")
        if (_shoeList.value == null) {
            _shoeList.value = mutableListOf(shoe)
            Timber.i("_shoeList.value == null\n==>\n_shoeList.value = mutableListOf(shoe) = ${_shoeList.value}")
        } else {
            _shoeList.value?.add(shoe)
            Timber.i("_shoeList.value != null\n==>\n_shoeList.value?.add(shoe) = ${_shoeList.value}")
        }
    }
}