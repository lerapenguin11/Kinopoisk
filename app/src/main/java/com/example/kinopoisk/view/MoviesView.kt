package com.example.kinopoisk.view

import com.example.kinopoisk.business.model.CategoriesModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MoviesView : MvpView {

    @AddToEndSingle
    fun displayRecommendationsMoviesData(data : List<CategoriesModel>)

    @AddToEndSingle
    fun displayError(error : Throwable)
}