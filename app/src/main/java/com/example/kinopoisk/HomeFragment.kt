package com.example.kinopoisk

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.business.model.CategoriesListModel
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import com.example.kinopoisk.databinding.FragmentHomeBinding
import com.example.kinopoisk.presenters.HomePresenter
import com.example.kinopoisk.view.HomeView
import com.example.kinopoisk.view.adapter.CategoriesAdapter
import com.example.kinopoisk.view.adapter.NewMoviesAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class HomeFragment : MvpAppCompatFragment(), HomeView {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val data = ArrayList<CategoriesListModel>()
    private val homePresenter by moxyPresenter { HomePresenter(this) }
    private lateinit var adapterNew: NewMoviesAdapter
    private val list = ArrayList<Movies>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homePresenter.enable()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initViews()
        displayCurrentData("Лера")

        binding.categoriesList.apply {
            adapter = CategoriesAdapter(data)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        homePresenter.start()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initViews(){
        /*data.add(CategoriesListModel(R.drawable.comedy, "Комедия"))
        data.add(CategoriesListModel(R.drawable.action_movie, "Боевик"))
        data.add(CategoriesListModel(R.drawable.detective, "Детектив"))
        data.add(CategoriesListModel(R.drawable.drama, "Драма"))
        data.add(CategoriesListModel(R.drawable.romance, "Мелодрама"))
        data.add(CategoriesListModel(R.drawable.mysticism, "Мистика"))
        data.add(CategoriesListModel(R.drawable.adventures, "Приключения"))
        data.add(CategoriesListModel(R.drawable.thriller, "Триллер"))
        data.add(CategoriesListModel(R.drawable.horrors, "Ужасы"))
        data.add(CategoriesListModel(R.drawable.fantastic, "Фантастика"))
        data.add(CategoriesListModel(R.drawable.fantasy, "Фэнтези"))*/
    }

    //-------------moxy-------------

    override fun displayCurrentData(data: String) {
        data.apply {
            binding.tvName.text = data
        }
    }

    //TODO применить данные из интернета
    override fun displayCategoriesData(data: List<CategoriesListModel>) {
        (binding.categoriesList.adapter as CategoriesAdapter)
    }

    //TODO применить данные из интернета
    override fun displayNewMoviesData(data: List<Movies>) {
        adapterNew = NewMoviesAdapter(data)
        binding.newMoviesList.setAdapter(adapterNew)
    }

    override fun displayError(error: Throwable) {
        println("Error:" + error.toString())
    }

    override fun setLoading(flag: Boolean) {

    }

    override fun init() {
        binding.newMoviesList.apply {
            adapter = NewMoviesAdapter(list)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        homePresenter.enable()
    }

    //-------------moxy-------------
}