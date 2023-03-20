package com.example.kinopoisk.business.repos

import com.example.kinopoisk.business.api.ApiProvider
import com.example.kinopoisk.business.model.CategoriesModel

class HomeRepository(api : ApiProvider) : BaseRepository<HomeRepository.ServerResponse>(api) {

    fun reloadData(field: String, search: String) {

    }


    data class ServerResponse(val name : String,
                              val recMovies : CategoriesModel,
                              val error : Throwable? = null)
}