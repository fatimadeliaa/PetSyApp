package com.adelianainggolan.petadoptionapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.adelianainggolan.petadoptionapp.R
import kotlinx.android.synthetic.main.activity_signin.*

class SignInActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, SignInActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        tv_to_signup.text = HtmlCompat.fromHtml(getString(R.string.go_to_signup), HtmlCompat.FROM_HTML_MODE_LEGACY)

        tv_to_signup.setOnClickListener {
            SignUpActivity.start(this)
        }

        btn_back_to_welcome.setOnClickListener {
            WelcomeActivity.start(this)
        }

        btn_signin.setOnClickListener {
            MainActivity.start(this)
        }

        tv_to_forget.setOnClickListener {
            ForgetActivity.start(this)
        }
    }
}