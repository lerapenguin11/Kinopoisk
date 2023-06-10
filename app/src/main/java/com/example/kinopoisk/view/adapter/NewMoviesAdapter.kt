package com.example.kinopoisk.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinopoisk.R
import com.example.kinopoisk.business.model.Doc
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import java.text.FieldPosition
import kotlin.text.StringBuilder

class NewMoviesAdapter(private val result : List<Doc>) : RecyclerView.Adapter<NewMoviesAdapter.NewMoviesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_movies, parent, false)

        return NewMoviesViewHolder(view)
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: NewMoviesViewHolder, position: Int) {

        return holder.bind(result[position])
    }

    class NewMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poster : ImageView = view.findViewById(R.id.poster_new_movies)
        val nameMovie : TextView = view.findViewById(R.id.tv_name)
        val rating : TextView = view.findViewById(R.id.new_films_imdb)


        fun bind(movie: Doc) {
            Glide.with(itemView.context).load(movie.poster.previewUrl).into(poster)
            nameMovie.text = movie.name
            rating.text = movie.rating.imdb.toBigDecimal().toPlainString()
        }
    }
}