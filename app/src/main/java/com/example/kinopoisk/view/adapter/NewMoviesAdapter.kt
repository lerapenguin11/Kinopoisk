package com.example.kinopoisk.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinopoisk.R
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import java.text.FieldPosition
import kotlin.text.StringBuilder

class NewMoviesAdapter(private val result : List<Movies>) : RecyclerView.Adapter<NewMoviesAdapter.NewMoviesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommendations_movies, parent, false)

        return NewMoviesViewHolder(view)
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: NewMoviesViewHolder, position: Int) {

        return holder.bind(result[position])
    }

    class NewMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poster : ImageView = view.findViewById(R.id.poster_rec_movies)
        val nameMovie : TextView = view.findViewById(R.id.tv_name_rec_movies)


        fun bind(movie: Movies) {
            Glide.with(itemView.context).load(movie.posterUrl).into(poster)
            nameMovie.text = movie.nameRu
        }
    }
}