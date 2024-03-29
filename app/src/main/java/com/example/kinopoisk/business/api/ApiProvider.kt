package com.example.kinopoisk.business.api

import com.example.kinopoisk.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
class ApiProvider {

    val kinopoisk : Retrofit by lazy { initApi() }

    fun initApi() =  Retrofit.Builder ()
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    fun providerMoviesApi() : MoviesApi = kinopoisk.create(MoviesApi :: class.java)
}