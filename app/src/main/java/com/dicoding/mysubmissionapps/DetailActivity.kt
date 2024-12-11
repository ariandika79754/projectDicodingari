package com.dicoding.mysubmissionapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.mysubmissionapps.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val anime = intent.getParcelableExtra<Anime>(MainActivity.INTENT_PARCELABLE)
        if (anime != null) {

            binding.generationTv.text = anime.generation.toString()
            binding.imageDetail.setImageResource(anime.photo)
            binding.nameDetailTv.text = anime.name
            binding.labelTv.text = anime.label
            binding.nicknameTv.text = anime.nickname
            binding.descriptionTv.text = anime.description
        }
    }
}