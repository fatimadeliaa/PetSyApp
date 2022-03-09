package com.adelianainggolan.petadoptionapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.adelianainggolan.petadoptionapp.R
import com.adelianainggolan.petadoptionapp.adapter.AllPetAdapter
import com.adelianainggolan.petadoptionapp.model.PetModel
import kotlinx.android.synthetic.main.activity_all_pet.*

class AllPetActivity : AppCompatActivity() {
    private val listPet = ArrayList<PetModel>()

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, AllPetActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_pet)
        rv_all_pet.setHasFixedSize(true)
        listPet.addAll(getListPet())
        showRecyclerGrid()

        supportActionBar?.hide()

        iv_back_all.setOnClickListener {
            finish()
        }
    }

    private fun getListPet(): Collection<PetModel> {
        var petImage = resources.obtainTypedArray(R.array.pet_image)
        var petName = resources.getStringArray(R.array.pet_name)
        var petSex = resources.getStringArray(R.array.pet_sex)
        var petJenis = resources.getStringArray(R.array.pet_jenis)
        var petAge = resources.getStringArray(R.array.pet_age)
        var petDistance = resources.getStringArray(R.array.pet_distance)
        var petWeight = resources.getStringArray(R.array.pet_weight)
        var petUser = resources.getStringArray(R.array.pet_user)
        var petUserBio = resources.getStringArray(R.array.pet_user_bio)
        var petDesc = resources.getStringArray(R.array.pet_desc)

        val listPet = ArrayList<PetModel>()

        for (position in petName.indices){
            val allPet = PetModel(
                petImage.getResourceId(position, -1),
                petName[position],
                petSex[position],
                petJenis[position],
                petAge[position],
                petDistance[position],
                petWeight[position],
                petUser[position],
                petUserBio[position],
                petDesc[position],
            )
            listPet.add(allPet)
        }
        return listPet
    }

    private fun showRecyclerGrid() {
        val layoutManagerStaggered = StaggeredGridLayoutManager(2, GridLayoutManager. VERTICAL)
        rv_all_pet.layoutManager = layoutManagerStaggered
        rv_all_pet.adapter = AllPetAdapter(listPet)
    }

}