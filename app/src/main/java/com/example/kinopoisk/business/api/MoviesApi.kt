package com.example.kinopoisk.business.api

import com.example.kinopoisk.business.model.CategoriesModel
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesApi {
    @Headers("X-API-KEY: 0d0acf1c-fefe-4d18-a4f7-bec01b716469",
        "Content-Type: application/json")
    @GET("/api/v2.2/films/{id}")
    fun getMovies(
    ) : Observable<List<Movies>>

    @Headers("X-API-KEY: 0d0acf1c-fefe-4d18-a4f7-bec01b716469")
    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS")
    fun getPopularMovie(): Call<MoviesModel>

    @Headers("X-API-KEY: 0d0acf1c-fefe-4d18-a4f7-bec01b716469")
    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS")
    fun getPopularMovie2(): Observable<List<Movies>>
}

