package com.example.kinopoisk.business.repos

import android.annotation.SuppressLint
import com.example.kinopoisk.business.api.ApiProvider
import com.example.kinopoisk.business.model.CategoriesModel


const val TAG = "HOME_REPO"

class HomeRepository(api : ApiProvider) : BaseRepository<HomeRepository.ServerResponse>(api) {

    @SuppressLint("CheckResult")
    fun reloadData() {

    }

    data class ServerResponse(
        val name: String,
        val newMovies: CategoriesModel,
        val error: Throwable? = null)
}