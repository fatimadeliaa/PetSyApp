package com.adelianainggolan.petadoptionapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adelianainggolan.petadoptionapp.R
import com.adelianainggolan.petadoptionapp.model.PetModel
import com.adelianainggolan.petadoptionapp.utils.setImage
import kotlinx.android.synthetic.main.activity_detail_pet.*

class PetDetailActivity : AppCompatActivity() {

    private var pet: PetModel? = null

    companion object {
        const val KEY_ALL_PET = "key_all_pet"

        fun start(context: Context, pet: PetModel) {
            val starter = Intent(context, PetDetailActivity::class.java)
            starter.putExtra(KEY_ALL_PET, pet)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pet)

        pet = intent.getParcelableExtra(KEY_ALL_PET)

        pet?.let { setDetail(it) }

        btn_back_from_detail.setOnClickListener {
            finish()
        }
    }

    private fun setDetail(pet: PetModel) {
        iv_detail_pet.setImage(this, pet.petImage)
        tv_detail_pet_name.setText(pet.petName)
        tv_detail_pet_sex.setText(pet.petSex)
        tv_detail_pet_jenis.setText(pet.petJenis)
        tv_detail_pet_age.setText(pet.petAge)
        tv_detail_pet_distance.setText(pet.petDistance)
        tv_detail_pet_weight.setText(pet.petWeight)
        tv_detail_pet_user.setText(pet.petUser)
        tv_detail_pet_user_bio.setText(pet.petUserBio)
        tv_detail_pet_desc.setText(pet.petDesc)
    }
}

