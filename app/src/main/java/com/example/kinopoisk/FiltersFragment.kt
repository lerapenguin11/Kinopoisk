package com.example.kinopoisk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.business.model.AllGenresItem
import com.example.kinopoisk.business.model.Doc
import com.example.kinopoisk.business.model.Genre
import com.example.kinopoisk.databinding.FragmentFullScreenFiltersBinding
import com.example.kinopoisk.presenters.FilterPresenter
import com.example.kinopoisk.view.FilterView
import com.example.kinopoisk.view.adapter.FilterTagAdapter
import com.example.kinopoisk.view.adapter.NewMoviesAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class FiltersFragment : MvpAppCompatFragment(), FilterView {
    private var _binding : FragmentFullScreenFiltersBinding? = null
    private val binding get() = _binding!!
    private val filterPresenter by moxyPresenter { FilterPresenter(this) }
    private lateinit var adapterGenre: FilterTagAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        filterPresenter.enable()

        _binding = FragmentFullScreenFiltersBinding.inflate(inflater, container, false)

        return binding.root
    }

    //------------Moxy-------------

    override fun displayGenresData(data: List<AllGenresItem>) {
        adapterGenre = FilterTagAdapter(data)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(context, 3)
        binding.rvFilterGenre!!.layoutManager = layoutManager
        binding.rvFilterGenre.adapter = adapterGenre
    }

    override fun displayCountryData(data: List<Doc>) {
    }

    override fun displayError(error: Throwable) {

    }

    //------------Moxy-------------
}