package com.adelianainggolan.petadoptionapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adelianainggolan.petadoptionapp.R
import com.adelianainggolan.petadoptionapp.utils.setImage
import kotlinx.android.synthetic.main.fragment_add_pet.*

class AddPetFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() =
            AddPetFragment().apply {
                arguments = Bundle().apply {  }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_pet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photo.setImage(requireContext(), R.drawable.pet_cat_image)
    }
}