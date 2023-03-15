package com.example.kinopoisk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.business.model.CategoriesModel
import com.example.kinopoisk.databinding.FragmentMoviesBinding
import com.example.kinopoisk.view.MoviesView
import com.example.kinopoisk.view.adapter.NewMoviesAdapter
import com.example.kinopoisk.view.adapter.RecommendationsAdapter

class MoviesFragment : Fragment(), MoviesView {
    private var _binding : FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView : RecyclerView
    private lateinit var rvRecommendationsAdapter : RecommendationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMoviesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recommendationsMoviesList.apply {
            recyclerView = findViewById<View>(R.id.recommendations_movies_list) as RecyclerView
            rvRecommendationsAdapter = RecommendationsAdapter()
            val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(context, 2)
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.adapter = rvRecommendationsAdapter

        }
    }

    //-------------moxy-------------

    override fun displayRecommendationsMoviesData(data: List<CategoriesModel>) {
        (binding.recommendationsMoviesList.adapter as RecommendationsAdapter).updateData(data)
    }

    override fun displayError(error: Throwable) {
        TODO("Not yet implemented")
    }

    //-------------moxy-------------
}