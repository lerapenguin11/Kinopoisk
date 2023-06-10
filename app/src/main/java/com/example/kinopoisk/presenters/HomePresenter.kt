package com.example.kinopoisk.presenters

import android.annotation.SuppressLint
import android.util.Log
import com.example.kinopoisk.business.TEST.Callback
import com.example.kinopoisk.business.api.ApiProvider
import com.example.kinopoisk.business.model.Doc
import com.example.kinopoisk.business.model.TEST
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import com.example.kinopoisk.business.repos.HomeRepository
import com.example.kinopoisk.view.HomeView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class HomePresenter(var mView : HomeView) : MvpPresenter<HomeView>() {

    //TODO переменная репо
    private val repo = HomeRepository(ApiProvider())

    @SuppressLint("CheckResult")
    fun enable() {
        repo.reloadData(object : Callback<List<Doc>>(){
            override fun returnResult(t: List<Doc>) {
                viewState.displayNewMoviesData(t)

            }

            override fun returnError(error: Throwable) {
                viewState.displayError(error)
            }


        })

        repo.reloadDataPopular(object : Callback<List<Doc>>(){
            override fun returnResult(t: List<Doc>) {
                viewState.displayPopularMoviesData(t)
            }

            override fun returnError(error: Throwable) {
                viewState.displayError(error)
            }

        })
    }
    fun start() {
        mView.init()
    }
}
