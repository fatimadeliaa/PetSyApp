package com.adelianainggolan.petadoptionapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adelianainggolan.petadoptionapp.MainActivity
import com.adelianainggolan.petadoptionapp.R
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_signin.*

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        btn_submit_to_profile.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_back_profile.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}