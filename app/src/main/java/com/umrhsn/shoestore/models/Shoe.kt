package com.umrhsn.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var name: String = "name",
    var size: Int = 0,
    var company: String = "company",
    var description: String = "description",
) :
    Parcelable