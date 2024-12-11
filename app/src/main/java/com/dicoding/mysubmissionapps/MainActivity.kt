package com.dicoding.mysubmissionapps

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mysubmissionapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Anime>()

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvAnime.setHasFixedSize(true)

        list.addAll(getListAnime())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListAnime(): ArrayList<Anime> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataNickname = resources.getStringArray(R.array.data_nicknames)
        val dataLabel = resources.getStringArray(R.array.data_label)
        val dataGeneration = resources.getIntArray(R.array.data_generation)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listAnime = ArrayList<Anime>()
        for(i in dataName.indices) {
            val name = dataName[i]
            val nicknames = dataNickname[i]
            val generation = dataGeneration[i]
            val label = dataLabel[i]
            val description = dataDescription[i]
            val photo = dataPhoto.getResourceId(i, -1)

            listAnime.add(Anime(
                name = name,
                nickname = nicknames,
                generation = generation,
                label = label,
                description = description,
                photo = photo
            ))
        }

        return listAnime
    }

    private fun showRecyclerList() {
        binding.rvAnime.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter = ListAnimeAdapter(list)
        binding.rvAnime.adapter = listAnimeAdapter
        listAnimeAdapter.setOnClickCallback(object : ListAnimeAdapter.OnItemClickCallback {
            override fun onItemClicked(anime: Anime) {
                showSelectedAnime(anime)
            }
        })
    }

    private fun showSelectedAnime(anime : Anime) {
        Toast.makeText(this, "Kamu memilih" + anime.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(INTENT_PARCELABLE, anime)
        startActivity(intent)
    }
}