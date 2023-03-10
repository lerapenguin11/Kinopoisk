package com.example.kinopoisk.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kinopoisk.R
import com.example.kinopoisk.business.model.CategoriesListModel

class CategoriesAdapter(private val categoriesList : List<CategoriesListModel>)
    : RecyclerView.Adapter<CategoriesAdapter.CategoriesHolderView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)

        return CategoriesHolderView(view)
    }

    override fun onBindViewHolder(holder: CategoriesHolderView, position: Int) {
        val itemList = categoriesList[position]

        holder.iconEmoji.setImageResource(itemList.iconEmoji)
        holder.tvCategories.text = itemList.categoriesText
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    inner class CategoriesHolderView(view : View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.ig_categories)
        lateinit var iconEmoji : ImageView

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_categories)
        lateinit var tvCategories : TextView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}