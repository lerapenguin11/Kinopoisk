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
import com.example.kinopoisk.business.repos.TAG
import com.example.kinopoisk.databinding.FragmentFavouritesBinding
import com.example.kinopoisk.view.adapter.FavoriteAdapter
import kotlinx.coroutines.DelicateCoroutinesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


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
        val call = request.getPopularMovie()

        call.enqueue(object : Callback<MoviesModel> {
            override fun onResponse(call: Call<MoviesModel>, response: Response<MoviesModel>) {
                if (response.isSuccessful && response != null){
                    println("CODE: " + response.code().toString())
                    binding.favoriteMoviesList.apply {
                        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                        println(response.body().toString())
                        adapter = FavoriteAdapter(response.body()!!.films)

                    }
                }
            }

            override fun onFailure(call: Call<MoviesModel>, t: Throwable) {
                Log.d("FATAL", "не работает")
            }

        })

        return binding.root
    }
}