package com.example.kinopoisk.business.api

import com.example.kinopoisk.business.model.AllGenres
import com.example.kinopoisk.business.model.Doc
import com.example.kinopoisk.business.model.TEST
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesApi {
    @Headers("X-API-KEY: YKEA3FF-QPT4Z39-MP0678S-HG5Q2QF",
        "Content-Type: application/json")
    @GET("movie?field=rating.kp&search=7-10&field=year&search=2017-2020&field=typeNumber&search=2&sortField=year&sortType=-1&sortField=votes.imdb&sortType=-1&limit=20")
    fun getMovies(
    ) : Observable<TEST>

    @Headers("X-API-KEY: YKEA3FF-QPT4Z39-MP0678S-HG5Q2QF",
        "Content-Type: application/json")
    @GET("v1.3/movie?field=rating.kp&search=7-10&field=year&search=1950-2023&field=typeNumber&search=1&sortField=votes.imdb&sortType=-1&limit=15")
    fun getMoviesPopular(
    ) : Observable<TEST>

    @Headers("X-API-KEY: YKEA3FF-QPT4Z39-MP0678S-HG5Q2QF",
        "Content-Type: application/json")
    @GET("v1.3/movie?field=rating.kp&search=1-10&field=year&search=2023&field=typeNumber&search=1&sortField=year&sortType=-1&sortField=votes.imdb&sortType=-1&limit=15")
    fun getNewsMovies() : Observable<TEST>

    //Список жанров
    @Headers("X-API-KEY: YKEA3FF-QPT4Z39-MP0678S-HG5Q2QF",
        "Content-Type: application/json")
    @GET("v1/movie/possible-values-by-field?field=genres.name&token=YKEA3FF-QPT4Z39-MP0678S-HG5Q2QF")
    fun getListGenre() : Observable<AllGenres>

    @Headers("X-API-KEY: 0d0acf1c-fefe-4d18-a4f7-bec01b716469")
    @GET("/api/v2.2/films/premieres?")
    fun getNewMovie2(
        @Query("year") year : Int = 2022,
        @Query("month") month : String = "JANUARY"
        ): Call<MoviesModel>
}

