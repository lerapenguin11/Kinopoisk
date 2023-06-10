package com.example.kinopoisk

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kinopoisk.business.TEST.RetrofitClient
import com.example.kinopoisk.business.api.MoviesApi
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import com.example.kinopoisk.databinding.FragmentFavouritesBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FavouritesFragment : Fragment() {
    lateinit var mService: MoviesApi
    lateinit var layoutManager: LinearLayoutManager
    private var _binding : FragmentFavouritesBinding? = null
    private val binding get() = _binding!!
    lateinit var api : RetrofitClient
    lateinit var list : ArrayList<Movies>

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        list = ArrayList<Movies>()



        val request = RetrofitClient.buildService(MoviesApi :: class.java)
        val call = request.getNewMovie2()



        return binding.root
    }
}