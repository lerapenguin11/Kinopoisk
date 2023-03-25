package com.example.kinopoisk.business.api

import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiProvider {

    private val kinopoisk : Retrofit by lazy { initApi() }
    private val SERVER_URL : String = "https://api.kinopoisk.dev/"

    private fun initApi() =  Retrofit.Builder ()
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(SERVER_URL)
        .build()
}