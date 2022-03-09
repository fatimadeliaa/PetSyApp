package com.adelianainggolan.petadoptionapp.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PetModel (
    @DrawableRes
    var petImage : Int,
    var petName : String,
    var petSex : String,
    var petJenis : String,
    var petAge: String,
    var petDistance : String,
    var petWeight : String,
    var petUser : String,
    var petUserBio : String,
    var petDesc : String,
) : Parcelable