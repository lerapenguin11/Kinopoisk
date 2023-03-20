package com.example.kinopoisk.presenters

import android.annotation.SuppressLint
import com.example.kinopoisk.business.api.ApiProvider
import com.example.kinopoisk.business.repos.HomeRepository
import com.example.kinopoisk.view.HomeView

class HomePresenter : BasePresenters<HomeView>() {
    //TODO переменная репо
    private val repo = HomeRepository(ApiProvider())

    @SuppressLint("CheckResult")
    override fun enable() {
        repo.dataEmitter.subscribe{response ->
            viewState.displayCurrentData()
            viewState.displayCategoriesData()
            response.error?.let{viewState.displayError()}

        }
    }

    fun refresh(field : String, search : String){
        //viewState.setLoading(true)
        repo.reloadData(field, search)
    }
}