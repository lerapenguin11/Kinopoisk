package com.example.kinopoisk.view

import com.example.kinopoisk.business.model.CategoriesListModel
import com.example.kinopoisk.business.model.CategoriesModel
import com.example.kinopoisk.business.model.NameData
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface HomeView : MvpView {

    @AddToEndSingle
    fun displayCurrentData(data : NameData)

    @AddToEndSingle
    fun displayCategoriesData(data : List<CategoriesListModel>)

    @AddToEndSingle
    fun displayNewMoviesData(data : List<CategoriesModel>)

    @AddToEndSingle
    fun displayError(error : Throwable)

    /*@AddToEndSingle
    fun setLoading(flag : Boolean)*/
}