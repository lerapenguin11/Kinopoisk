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
import com.example.kinopoisk.business.model.Genre

class PopularAdapter (private val result : List<Doc>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular, parent, false)

        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {

        return holder.bind(result[position])
    }

    class PopularViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poster : ImageView = view.findViewById(R.id.poster_popular)
        val nameMovie : TextView = view.findViewById(R.id.tv_name)
        val rating : TextView = view.findViewById(R.id.popular_films_imdb)
        val genre_1 : TextView = view.findViewById(R.id.tv_tag_genre1)
        val time_movie_length : TextView = view.findViewById(R.id.tv_movie_length)

        fun bind(movie: Doc) {
            Glide.with(itemView.context).load(movie.poster.previewUrl).into(poster)
            nameMovie.text = movie.name
            rating.text = movie.rating.imdb.toBigDecimal().toPlainString()
            time_movie_length.text = movie.movieLength.toString()
            genre_1.text = movie.genres[0].name
        }
    }
}