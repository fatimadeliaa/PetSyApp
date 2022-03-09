package com.adelianainggolan.petadoptionapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.adelianainggolan.petadoptionapp.R
import com.adelianainggolan.petadoptionapp.activity.EditProfileActivity
import com.adelianainggolan.petadoptionapp.utils.setImage
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle()
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        img_cat.setImage(requireContext(), R.drawable.pet_cat_image)
        img_dog.setImage(requireContext(), R.drawable.pet_dog_image)
        img_bird.setImage(requireContext(), R.drawable.pet_bird_image)

        iv_edit_profile.setOnClickListener {
            EditProfileActivity.start(requireContext())
        }
    }
}