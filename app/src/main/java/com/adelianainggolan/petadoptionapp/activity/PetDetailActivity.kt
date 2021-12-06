package com.adelianainggolan.petadoptionapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adelianainggolan.petadoptionapp.MainActivity
import com.adelianainggolan.petadoptionapp.R
import com.adelianainggolan.petadoptionapp.model.PetModel
import kotlinx.android.synthetic.main.activity_detail_pet.*
import kotlinx.android.synthetic.main.activity_edit_profile.*

class PetDetailActivity : AppCompatActivity() {
    companion object {
        const val KEY_ALL_PET = "key_all_pet"
    }

    private var model: PetModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pet)

        model = intent.getParcelableExtra(KEY_ALL_PET)

        iv_detail_pet.setImageResource(model?.petImage!!)
        tv_detail_pet_name.setText(model?.petName)
        tv_detail_pet_sex.setText(model?.petSex)
        tv_detail_pet_jenis.setText(model?.petJenis)
        tv_detail_pet_age.setText(model?.petAge)
        tv_detail_pet_distance.setText(model?.petDistance)
        tv_detail_pet_weight.setText(model?.petWeight)
        tv_detail_pet_user.setText(model?.petUser)
        tv_detail_pet_user_bio.setText(model?.petUserBio)
        tv_detail_pet_desc.setText(model?.petDesc)

        btn_back_from_detail.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}

