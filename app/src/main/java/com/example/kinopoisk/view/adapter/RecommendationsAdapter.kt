package com.example.kinopoisk.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.example.kinopoisk.R
import com.example.kinopoisk.business.model.CategoriesModel

class RecommendationsAdapter : BaseAdapter<CategoriesModel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommendations_movies, parent, false)

        return RecommendationsHolderView(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class RecommendationsHolderView(view : View) : BaseHolderView(view){

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.poster_rec_movies)
        lateinit var posterRecMovies : ImageView

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_name_rec_movies)
        lateinit var nameRecMovies : TextView

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_estimation)
        lateinit var estimation : TextView

        override fun bindView(position: Int) {
            posterRecMovies.setImageResource(R.drawable.defolt_poster)
            nameRecMovies.text = "fdgfgf"
            estimation.text = "8.1"
        }

    }
}