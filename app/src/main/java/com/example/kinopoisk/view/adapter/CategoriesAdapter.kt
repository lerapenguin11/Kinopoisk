package com.example.kinopoisk.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.R

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoriesHolderView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)

        return CategoriesHolderView(view)
    }

    override fun onBindViewHolder(holder: CategoriesHolderView, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class CategoriesHolderView(view : View) : RecyclerView.ViewHolder(view) {

    }
}