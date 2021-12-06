package com.adelianainggolan.petadoptionapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adelianainggolan.petadoptionapp.R

class AddPetFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_pet, container, false)
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            AddPetFragment().apply {
                arguments = Bundle().apply {  }
            }
    }
}