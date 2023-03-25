package com.example.kinopoisk.view

import com.example.kinopoisk.business.model.CategoriesListModel
import com.example.kinopoisk.business.model.CategoriesModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface HomeView : MvpView {

    @AddToEndSingle
    fun displayCurrentData(data: String)

    @AddToEndSingle
    fun displayCategoriesData(data : List<CategoriesListModel>)

    @AddToEndSingle
    fun displayNewMoviesData(data: CategoriesModel)

    @AddToEndSingle
    fun displayError(error : Throwable)

    /*@AddToEndSingle
    fun setLoading(flag : Boolean)*/
}