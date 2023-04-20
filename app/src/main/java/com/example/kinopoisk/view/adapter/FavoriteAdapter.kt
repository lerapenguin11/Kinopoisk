package com.example.kinopoisk.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.bumptech.glide.Glide
import com.example.kinopoisk.R
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel

class FavoriteAdapter(private val result : List<Movies>) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommendations_movies, parent, false)

        return FavoriteViewHolder(view)
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {

        return holder.bind(result[position])
    }

    class FavoriteViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val poster : ImageView = view.findViewById(R.id.poster_rec_movies)
        val nameMovie : TextView = view.findViewById(R.id.tv_name_rec_movies)


        fun bind(movie: Movies) {
            Glide.with(itemView.context).load(movie.posterUrl).into(poster)
            nameMovie.text = movie.nameRu
        }
    }
}