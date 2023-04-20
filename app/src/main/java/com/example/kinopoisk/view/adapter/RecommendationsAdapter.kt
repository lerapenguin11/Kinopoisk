package com.example.kinopoisk.view.adapter

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kinopoisk.R
import com.example.kinopoisk.business.model.CategoriesModel
import retrofit2.adapter.rxjava3.Result.response


class RecommendationsAdapter : BaseAdapter<CategoriesModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommendations_movies, parent, false)

        return RecommendationsHolderView(view)
    }

    inner class RecommendationsHolderView(view : View) : BaseHolderView(view){
        public lateinit var model: CategoriesModel

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.poster_rec_movies)
        lateinit var posterRecMovies : ImageView

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_name_rec_movies)
        lateinit var nameRecMovies : TextView

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_estimation)
        lateinit var estimation : TextView

        init {
            ButterKnife.bind(this, itemView)
        }


        override fun bindView(position: Int) {

            mData[position].apply {
                //posterRecMovies.setImageURI(poster[0].url.toUri())
                nameRecMovies.text = "Офис"
                estimation.text = "8.1"
            }

        }

    }
}