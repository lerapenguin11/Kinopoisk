package com.example.kinopoisk.business.api

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie?")
    fun getMovies(
        @Query("field") field : String = "year",
        @Query("search") search : String = "2022-2023",
        @Query("token") token : String = "VFA9TAW-4H94F2B-NSRGV52-JN7G2A3"
    )

    /*field=rating.kp
    &search=7-10
    &field=year
    &search=2017-2020
    &field=typeNumber
    &search=2
    &sortField=year
    &sortType=1
    &sortField=votes.imdb
    &sortType=-1
    &token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06*/
}