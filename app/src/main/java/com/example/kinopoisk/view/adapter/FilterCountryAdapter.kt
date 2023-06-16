package com.example.kinopoisk.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.R
import com.example.kinopoisk.business.model.AllCountriesItem


class FilterCountryAdapter(private val result : List<AllCountriesItem>) : RecyclerView.Adapter<FilterCountryAdapter.FilterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filter_on_click, parent, false)

        return FilterViewHolder(view)
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(result[position])

    }

    class FilterViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tagOnClick : ConstraintLayout = view.findViewById(R.id.filter_on_click)
        val tagNotClick : ConstraintLayout = view.findViewById(R.id.filter_not_click)
        val tvTagOnClick : TextView = view.findViewById(R.id.tv_genre_on_click)
        val tvTagNotClick : TextView = view.findViewById(R.id.tv_genre_not_click)

        fun bind(country: AllCountriesItem) {
            tagNotClick.visibility = View.VISIBLE
            tvTagNotClick.text = country.name

            tagNotClick.setOnClickListener {
                tagNotClick.visibility = View.INVISIBLE

                tagOnClick.visibility = View.VISIBLE
                tvTagOnClick.text = country.name
            }

            tagOnClick.setOnClickListener {
                tagOnClick.visibility = View.INVISIBLE

                tagNotClick.visibility = View.VISIBLE
                tvTagNotClick.text = country.name
            }
        }
    }
}