package com.example.kinopoisk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {
    private var _binding : FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView : RecyclerView

    //private val homePresenter by moxyPresenter { HomePresenter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        initRetrofit()


        return binding.root
    }

    private fun initRetrofit() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



    //-------------moxy-------------
}