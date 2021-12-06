package com.adelianainggolan.petadoptionapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.adelianainggolan.petadoptionapp.MainActivity
import com.adelianainggolan.petadoptionapp.R
import kotlinx.android.synthetic.main.activity_signin.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        tv_to_signup.text = HtmlCompat.fromHtml(getString(R.string.go_to_signup), HtmlCompat.FROM_HTML_MODE_LEGACY)

        tv_to_signup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        btn_back_to_welcome.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

        btn_signin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        tv_to_forget.setOnClickListener {
            startActivity(Intent(this, ForgetActivity::class.java))
        }
    }
}