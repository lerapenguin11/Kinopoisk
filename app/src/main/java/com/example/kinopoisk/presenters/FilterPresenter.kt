package com.example.kinopoisk.presenters

import com.example.kinopoisk.business.TEST.Callback
import com.example.kinopoisk.business.api.ApiProvider
import com.example.kinopoisk.business.model.AllGenresItem
import com.example.kinopoisk.business.model.Doc
import com.example.kinopoisk.business.model.Genre
import com.example.kinopoisk.business.repos.FilterRepository
import com.example.kinopoisk.business.repos.HomeRepository
import com.example.kinopoisk.view.FilterView
import moxy.MvpPresenter

class FilterPresenter(var mView : FilterView) : MvpPresenter<FilterView>() {

    private val repo = FilterRepository(ApiProvider())

    fun enable(){
        repo.reloadDataGenre(object : Callback<List<AllGenresItem>>(){
            override fun returnResult(t: List<AllGenresItem>) {
                viewState.displayGenresData(t)
            }

            override fun returnError(error: Throwable) {
                viewState.displayError(error)
            }
        })
    }


}