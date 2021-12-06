package com.adelianainggolan.petadoptionapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adelianainggolan.petadoptionapp.R
import kotlinx.android.synthetic.main.activity_forgotpassword.*
import kotlinx.android.synthetic.main.activity_signin.*

class ForgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        iv_back_to_signin.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }

        btn_confirm_to_verifikasi.setOnClickListener {
            startActivity(Intent(this, VerifikasiActivity::class.java))
        }
    }
}