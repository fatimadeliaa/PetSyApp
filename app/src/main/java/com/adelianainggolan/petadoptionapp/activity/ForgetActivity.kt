package com.adelianainggolan.petadoptionapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adelianainggolan.petadoptionapp.R
import kotlinx.android.synthetic.main.activity_forgotpassword.*

class ForgetActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, ForgetActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        iv_back_to_signin.setOnClickListener {
            SignInActivity.start(this)
        }

        btn_confirm_to_verifikasi.setOnClickListener {
            VerificationActivity.start(this)
        }
    }
}