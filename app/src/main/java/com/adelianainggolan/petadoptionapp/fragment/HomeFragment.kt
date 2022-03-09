package com.adelianainggolan.petadoptionapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.adelianainggolan.petadoptionapp.R
import com.adelianainggolan.petadoptionapp.activity.AllPetActivity
import com.adelianainggolan.petadoptionapp.activity.PetDetailActivity
import com.adelianainggolan.petadoptionapp.activity.SettingActivity
import com.adelianainggolan.petadoptionapp.adapter.CategoryAdapter
import com.adelianainggolan.petadoptionapp.adapter.ImageSliderAdapter
import com.adelianainggolan.petadoptionapp.model.CategoryPetModel
import com.adelianainggolan.petadoptionapp.model.PetModel
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.ArrayList
import com.adelianainggolan.petadotionapp.adapter.HomeAdapter

class HomeFragment : Fragment() {

    private val pets = ArrayList<PetModel>()
    private val catPets = ArrayList<CategoryPetModel>()
    private lateinit var viewPager: ViewPager
    private lateinit var homeAdapter : HomeAdapter
    private lateinit var imageSliderAdapter: ImageSliderAdapter
    private lateinit var categoryAdapter: CategoryAdapter

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {  }
            }
    }

    private val images: IntArray by lazy {
        intArrayOf(
            R.drawable.pet_cat_image, R.drawable.pet_dog_image, R.drawable.pet_bird_image, R.drawable.pet_hamster_image,
            R.drawable.pet_fish_image
        )
    }

    override fun onCreateView( // saat tampilan dibuat
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // saat tampilan telah dibuat
        super.onViewCreated(view, savedInstanceState)
        viewPager = vp_home_slider
        pets.addAll(getListPet())
        catPets.addAll(getListPetCat())

        showPetSlider()
        showPetList()
        showPetCategoryList()

        tv_showall.setOnClickListener {
            AllPetActivity.start(requireContext())
        }

        iv_setting.setOnClickListener {
            SettingActivity.start(requireContext())
        }
    }

    private fun showPetSlider() {
        imageSliderAdapter = ImageSliderAdapter(requireContext(), images)
        viewPager.adapter = imageSliderAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showPetCategoryList() {
        categoryAdapter = CategoryAdapter(catPets)
        categoryAdapter.notifyDataSetChanged()
        rv_pet_category.adapter = categoryAdapter
        rv_pet_category.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_pet_category.setHasFixedSize(true)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showPetList() {
        homeAdapter = HomeAdapter { showDetails(it) }
        homeAdapter.notifyDataSetChanged()
        homeAdapter.setData(getListPet())
        rv_pet_general.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_pet_general.adapter = homeAdapter
        rv_pet_general.setHasFixedSize(true)
    }

    private fun showDetails(it: PetModel) {
        PetDetailActivity.start(requireContext(), it)
    }


    private fun getListPetCat(): ArrayList<CategoryPetModel> {
        val petIcon = resources.obtainTypedArray(R.array.category_pet_icon)
        val petCategory = resources.getStringArray(R.array.category_pet_name)

        val model = ArrayList<CategoryPetModel>()

        for (position in petCategory.indices){
            val petCat = CategoryPetModel(
                petIcon.getResourceId(position, -1),
                petCategory[position],

            )
            model.add(petCat)
        }
        return model
    }

    private fun getListPet(): ArrayList<PetModel> {
        val petImage = resources.obtainTypedArray(R.array.pet_image)
        val petName = resources.getStringArray(R.array.pet_name)
        val petSex = resources.getStringArray(R.array.pet_sex)
        val petJenis = resources.getStringArray(R.array.pet_jenis)
        val petAge = resources.getStringArray(R.array.pet_age)
        val petDistance = resources.getStringArray(R.array.pet_distance)
        val petWeight = resources.getStringArray(R.array.pet_weight)
        val petUser = resources.getStringArray(R.array.pet_user)
        val petUserBio = resources.getStringArray(R.array.pet_user_bio)
        val petDesc = resources.getStringArray(R.array.pet_desc)

        val model = ArrayList<PetModel>()

        for (position in petName.indices){
            val novel = PetModel(
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
            model.add(novel)
        }
        return model
    }
}