package com.adelianainggolan.petadoptionapp.fragment

import android.annotation.SuppressLint
import android.content.Intent
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
    private val model = ArrayList<PetModel>()
    private val modelCatPet = ArrayList<CategoryPetModel>()
    private lateinit var homeAdapter : HomeAdapter
//    private lateinit var categoryAdapter: CategoryAdapter


    companion object {
        fun newInstance() : HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    // creating object of ViewPager
    var mViewPager: ViewPager? = null

    // images array
    var images = intArrayOf(
        R.drawable.pet_cat_image, R.drawable.pet_dog_image, R.drawable.pet_bird_image, R.drawable.pet_hamster_image,
        R.drawable.pet_fish_image
    )

    // Creating Object of ViewPagerAdapter
    var mImageSliderAdapter: ImageSliderAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initializing the ViewPager Object
        mViewPager = vp_home_slider as ViewPager

        // Initializing the ViewPagerAdapter
        mImageSliderAdapter = ImageSliderAdapter(requireContext(), images)

        // Adding the Adapter to the ViewPager
        mViewPager!!.adapter = mImageSliderAdapter

        model.addAll(getListPet())
        rv_pet_general.setHasFixedSize(true)

        modelCatPet.addAll(getListPetCat())
        rv_pet_category.setHasFixedSize(true)

        showPetList()
        showPetCategoryList()

        tv_showall.setOnClickListener {
            val intent = Intent(context, AllPetActivity::class.java)
            startActivity(intent)
        }

        iv_setting.setOnClickListener {
            val intent = Intent(context, SettingActivity::class.java)
            startActivity(intent)
        }


    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showPetCategoryList() {

        rv_pet_category.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val categoryAdapter = CategoryAdapter(modelCatPet)
        rv_pet_category.adapter = categoryAdapter
//        rv_pet_category.setHasFixedSize(true)
    }

    private fun showPetList() {
        homeAdapter = HomeAdapter { showDetails(it) }
        homeAdapter.notifyDataSetChanged()
        homeAdapter.setData(getListPet())
        rv_pet_general.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_pet_general.adapter = homeAdapter
        rv_pet_general.setHasFixedSize(true)
    }

    private fun showDetails(it: PetModel) {
        val intent = Intent(context, PetDetailActivity::class.java)
        intent.putExtra(PetDetailActivity.KEY_ALL_PET, it)
        startActivity(intent)
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