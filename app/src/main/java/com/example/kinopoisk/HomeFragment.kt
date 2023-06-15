package com.example.kinopoisk

import android.R
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.business.model.Doc
import com.example.kinopoisk.business.modelView.CategoriesListModel
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import com.example.kinopoisk.databinding.FragmentHomeBinding
import com.example.kinopoisk.presenters.HomePresenter
import com.example.kinopoisk.view.HomeView
import com.example.kinopoisk.view.adapter.CategoriesAdapter
import com.example.kinopoisk.view.adapter.NewMoviesAdapter
import com.example.kinopoisk.view.adapter.PopularAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class HomeFragment : MvpAppCompatFragment(), HomeView {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homePresenter by moxyPresenter { HomePresenter(this) }
    private lateinit var adapterNew: NewMoviesAdapter
    private lateinit var adapterPopular : PopularAdapter
    private val list = ArrayList<Doc>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homePresenter.enable()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homePresenter.start()

        return binding.root
    }


    override fun onResume() {
        super.onResume()
        onClick()
    }

    private fun onClick() {
        binding.btFilter.setOnClickListener {
            sideFilter()
        }
    }

    private fun sideFilter() {
        val dialog = context?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)

        //dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    //-------------moxy-------------

    override fun displayNewMoviesData(data: List<Doc>) {
        adapterNew = NewMoviesAdapter(data)
        binding.rvNewFilm.setAdapter(adapterNew)
    }

    override fun displayPopularMoviesData(data: List<Doc>) {
        adapterPopular = PopularAdapter(data)
        binding.rvPopular.setAdapter(adapterPopular)
    }

    override fun displayError(error: Throwable) {
        println("Error:" + error.toString())
    }

    override fun setLoading(flag: Boolean) {
    }

    override fun init() {
        /*binding.rvNewFilm.apply {
            adapter = NewMoviesAdapter(list)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        homePresenter.enable()*/
    }

    //-------------moxy-------------
}