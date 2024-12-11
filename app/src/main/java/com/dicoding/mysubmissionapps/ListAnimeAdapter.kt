package com.dicoding.mysubmissionapps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mysubmissionapps.databinding.ItemRowAnimeBinding

class ListAnimeAdapter(private val listAnime: ArrayList<Anime>) : RecyclerView.Adapter<ListAnimeAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data : Anime)
    }

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(val binding: ItemRowAnimeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listAnime.size
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val anime = listAnime[position]
        val (name, _, _, generation, label, photo) = anime
        holder.binding.nameDetailTv.text = name
        holder.binding.generationTv.inputType = generation
        holder.binding.labelTv.text = label
        holder.binding.imageDetail.setImageResource(photo)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(anime)
        }
    }
}

