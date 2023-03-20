package com.example.kinopoisk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kinopoisk.business.model.CategoriesListModel
import com.example.kinopoisk.business.model.CategoriesModel
import com.example.kinopoisk.business.model.NameData
import com.example.kinopoisk.databinding.FragmentHomeBinding
import com.example.kinopoisk.view.HomeView
import com.example.kinopoisk.view.adapter.CategoriesAdapter
import com.example.kinopoisk.view.adapter.NewMoviesAdapter

class HomeFragment : Fragment(), HomeView {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val data = ArrayList<CategoriesListModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initViews()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.categoriesList.apply {
            adapter = CategoriesAdapter(data)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.newMoviesList.apply {
            adapter = NewMoviesAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initViews(){
        data.add(CategoriesListModel(R.drawable.comedy, "Комедия"))
        data.add(CategoriesListModel(R.drawable.action_movie, "Боевик"))
        data.add(CategoriesListModel(R.drawable.detective, "Детектив"))
        data.add(CategoriesListModel(R.drawable.drama, "Драма"))
        data.add(CategoriesListModel(R.drawable.romance, "Мелодрама"))
        data.add(CategoriesListModel(R.drawable.mysticism, "Мистика"))
        data.add(CategoriesListModel(R.drawable.adventures, "Приключения"))
        data.add(CategoriesListModel(R.drawable.thriller, "Триллер"))
        data.add(CategoriesListModel(R.drawable.horrors, "Ужасы"))
        data.add(CategoriesListModel(R.drawable.fantastic, "Фантастика"))
        data.add(CategoriesListModel(R.drawable.fantasy, "Фэнтези"))
    }

    //-------------moxy-------------

    override fun displayCurrentData(data: NameData) {
        binding.tvName.text = "Лера"
    }

    //TODO применить данные из интернета
    override fun displayCategoriesData(data: List<CategoriesListModel>) {
        (binding.categoriesList.adapter as CategoriesAdapter)
    }

    //TODO применить данные из интернета
    override fun displayNewMoviesData(data: List<CategoriesModel>) {
        (binding.newMoviesList.adapter as NewMoviesAdapter).updateData(data)
    }

    override fun displayError(error: Throwable) {

    }

    //-------------moxy-------------
}