package com.example.kinopoisk.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kinopoisk.R
import com.example.kinopoisk.business.model.CategoriesModel

class NewMoviesAdapter : BaseAdapter<CategoriesModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMoviesHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_movies, parent, false)

        return NewMoviesHolderView(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class NewMoviesHolderView(view : View) : BaseHolderView(view){

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.poster_new_movies)
        lateinit var posterNewMovies : ImageView

        init {
            ButterKnife.bind(this, itemView)
        }

        override fun bindView(position: Int) {
            posterNewMovies.setImageResource(R.drawable.defolt_poster)
        }

    }
}