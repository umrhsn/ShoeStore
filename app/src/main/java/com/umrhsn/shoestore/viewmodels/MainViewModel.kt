package com.umrhsn.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umrhsn.shoestore.models.Shoe
import timber.log.Timber

class MainViewModel : ViewModel() {
    var currentShoe: Shoe? = null

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>> get() = _shoeList

    private var _eventClosed = MutableLiveData<Boolean?>()
    val eventClosed: MutableLiveData<Boolean?> get() = _eventClosed

    init {
        _eventClosed.value = false
    }

    fun saveShoeData() {
        val tempShoeList = mutableListOf<Shoe>()
        _shoeList.value?.let { shoeList ->
            tempShoeList.addAll(shoeList)
        }
        currentShoe?.let { shoe ->
            tempShoeList.add(shoe)
        }
        _shoeList.value = tempShoeList
        closeShoeDetailFragment()
    }

    fun isListEmpty(): Boolean {
        Timber.i("isListEmpty called\n" + "_shoeList.value = ${_shoeList.value}")
        val isEmpty = _shoeList.value == null || _shoeList.value?.isEmpty() == true
        Timber.i("isEmpty = $isEmpty")
        return isEmpty
    }

    fun closeShoeDetailFragment() {
        _eventClosed.value = true
    }

    fun onCloseEventComplete() {
        _eventClosed.value = null
    }
}