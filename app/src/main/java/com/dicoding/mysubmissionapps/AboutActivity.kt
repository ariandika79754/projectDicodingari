package com.dicoding.mysubmissionapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.mysubmissionapps.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val aboutMe = intent.getParcelableExtra<AboutMe>(MainActivity.INTENT_PARCELABLE)
        if (aboutMe != null) {

            binding.imageAboutIv.setImageResource(aboutMe.photo)
            binding.namesayaTv.text = aboutMe.name
            binding.emailadressTv.text = aboutMe.email
        }

    }
}

