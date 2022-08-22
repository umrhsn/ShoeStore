package com.umrhsn.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Int, var company: String, var description: String) :
    Parcelable