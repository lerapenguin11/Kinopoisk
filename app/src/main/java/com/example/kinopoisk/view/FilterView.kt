package com.example.kinopoisk.view

import com.example.kinopoisk.business.model.AllGenresItem
import com.example.kinopoisk.business.model.Doc
import com.example.kinopoisk.business.model.Genre
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface FilterView : MvpView {
    @AddToEndSingle
    fun displayGenresData(data: List<AllGenresItem>)

    @AddToEndSingle
    fun displayCountryData(data: List<Doc>)

    @AddToEndSingle
    fun displayError(error : Throwable)
}