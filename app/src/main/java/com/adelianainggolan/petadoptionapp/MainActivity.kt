package com.adelianainggolan.petadoptionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.adelianainggolan.petadoptionapp.fragment.AddPetFragment
import com.adelianainggolan.petadoptionapp.fragment.HomeFragment
import com.adelianainggolan.petadoptionapp.fragment.ProfileFragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addFragments(HomeFragment.newInstance())
        nav_main.show(0)
        nav_main.add(MeowBottomNavigation.Model(0,R.drawable.ic_home))
        nav_main.add(MeowBottomNavigation.Model(1, R.drawable.ic_upload))
        nav_main.add(MeowBottomNavigation.Model(2, R.drawable.ic_profile))

        nav_main.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    replaceFragment(HomeFragment.newInstance())
                }
                1 -> {
                    replaceFragment(AddPetFragment.newInstance())
                }
                2 -> {
                    replaceFragment(ProfileFragment.newInstance())
                }
                else -> {
                    replaceFragment(HomeFragment.newInstance())
                }
            }
        }

        val defaultMainView = HomeFragment.newInstance()
        addFragments(defaultMainView)
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fm_main, fragment).addToBackStack(Fragment::class.java.simpleName).commit()

    }
    private fun addFragments(fragment: Fragment){
        val fragTransition = supportFragmentManager.beginTransaction()
        fragTransition.add(R.id.fm_main, fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

}