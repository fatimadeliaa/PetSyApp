package com.adelianainggolan.petadoptionapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.adelianainggolan.petadoptionapp.MainActivity
import com.adelianainggolan.petadoptionapp.R
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.fragment_profile.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        btn_theme.setOnCheckedChangeListener { button, b ->
            if (btn_theme.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        btn_back_setting.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}