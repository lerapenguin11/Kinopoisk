package com.example.kinopoisk.view

import com.example.kinopoisk.business.model.Doc
import com.example.kinopoisk.business.modelView.CategoriesListModel
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface HomeView : MvpView {

    @AddToEndSingle
    fun displayNewMoviesData(data: List<Doc>)

    @AddToEndSingle
    fun displayPopularMoviesData(data: List<Doc>)

    @AddToEndSingle
    fun displayError(error : Throwable)

    @AddToEndSingle
    fun setLoading(flag : Boolean)

    @AddToEndSingle
    fun init()
}
