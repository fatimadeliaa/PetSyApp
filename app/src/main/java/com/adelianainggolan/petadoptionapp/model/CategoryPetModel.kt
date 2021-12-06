package com.adelianainggolan.petadoptionapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryPetModel (
    var petIcon: Int,
    var petCategory : String,
) : Parcelable