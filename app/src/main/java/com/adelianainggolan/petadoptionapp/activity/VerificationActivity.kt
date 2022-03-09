package com.adelianainggolan.petadoptionapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adelianainggolan.petadoptionapp.R
import kotlinx.android.synthetic.main.activity_verifikasi.*

class VerificationActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, VerificationActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifikasi)

        btn_confirm_to_home.setOnClickListener {
            MainActivity.start(this)
        }

        btn_back_confirm.setOnClickListener {
            SignInActivity.start(this)
        }
    }
}