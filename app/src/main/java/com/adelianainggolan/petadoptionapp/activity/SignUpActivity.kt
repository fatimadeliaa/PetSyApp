package com.adelianainggolan.petadoptionapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.adelianainggolan.petadoptionapp.R
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, SignUpActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        tv_to_signin.text = HtmlCompat.fromHtml("Already have an account? <b>Sign In</b>", HtmlCompat.FROM_HTML_MODE_LEGACY)

        tv_to_signin.setOnClickListener {
            SignInActivity.start(this)
        }

        btn_back_to_signin.setOnClickListener {
            finish()
        }

        btn_signup.setOnClickListener {
            MainActivity.start(this)
        }
    }
}