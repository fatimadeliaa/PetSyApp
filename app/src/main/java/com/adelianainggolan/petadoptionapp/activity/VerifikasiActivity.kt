package com.adelianainggolan.petadoptionapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adelianainggolan.petadoptionapp.MainActivity
import com.adelianainggolan.petadoptionapp.R
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.activity_verifikasi.*

class VerifikasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifikasi)

        btn_confirm_to_home.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_back_confirm.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}