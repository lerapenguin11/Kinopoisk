package com.example.kinopoisk.presenters

import android.annotation.SuppressLint
import android.util.Log
import com.example.kinopoisk.business.api.ApiProvider
import com.example.kinopoisk.business.repos.HomeRepository
import com.example.kinopoisk.view.HomeView

class HomePresenter : BasePresenters<HomeView>() {
    //TODO переменная репо
    private val repo = HomeRepository(ApiProvider())

    @SuppressLint("CheckResult")
    override fun enable() {
        repo.dataEmitter.subscribe{response ->
            Log.d("HOME_REPO", "Presenter enable(): $response" )
            viewState.displayCurrentData(response.name)
            //viewState.displayCategoriesData()
            viewState.displayNewMoviesData(response.newMovies)
            response.error?.let{viewState.displayError(response.error)}

        }
    }
}